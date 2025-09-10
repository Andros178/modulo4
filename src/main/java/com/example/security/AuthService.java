package com.example.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.estado.Estado;
import com.example.estado.repositories.EstadoRepository;
import com.example.keycloak.KeycloakAdminService;
import com.example.keycloak.KeycloakTokenService;
import com.example.keycloak.dtos.TokenResponse;
import com.example.loginRequest.LoginRequest;
import com.example.loginRequest.RegisterRequest;
import com.example.persona.Persona;
import com.example.persona.repositories.PersonaRepository;
import com.example.usuario.Usuario;
import com.example.usuario.repositories.UsuarioRepository;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final KeycloakTokenService keycloakTokenService;
    private final KeycloakAdminService keycloakAdminService;
    private final PersonaRepository personaRepository;
    private final EstadoRepository estadoRepository;

    public ResponseEntity<?> login(LoginRequest request, String redirect) {
        // 1) Autenticar contra tu UserDetailsService (BD) usando Spring Security
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException ex) {
            log.warn("Credenciales inválidas para usuario {}", request.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (DisabledException | LockedException e) {
            log.warn("Usuario inhabilitado/bloqueado {}", request.getUsername());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 2) Recuperar usuario y roles desde BD
        Usuario usuario = usuarioRepository.findByLogin(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no existe en BD"));

        // Asumiendo que Usuario tiene getUsuarioRoles() -> cada uno tiene getRol().getNombre() (ajusta si difiere)
        Set<String> roles = usuario.getUsuarioRoles() == null ? Set.of() :
                usuario.getUsuarioRoles().stream()
                        .map(ur -> ur.getRol().getNombre())
                        .collect(Collectors.toSet());

        // 3) Sincronizar usuario y roles en Keycloak antes de pedir token
        try {
            keycloakAdminService.ensureUserExists(usuario.getLogin(), usuario.getLogin()+"@local", true, request.getPassword());
            for (String roleName : roles) {
                keycloakAdminService.ensureRealmRole(roleName);
                keycloakAdminService.ensureUserHasRealmRole(usuario.getLogin(), roleName);
            }
        } catch (Exception e) {
            log.error("Error sincronizando usuario/roles en Keycloak", e);
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }

        // 4) Obtener token (Direct Access Grant) ya con roles asignados
        JsonNode tokenJson = keycloakTokenService.directGrant(request.getUsername(), request.getPassword());
        if (tokenJson == null || !tokenJson.has("access_token")) {
            log.error("Keycloak no devolvió access_token para {}", request.getUsername());
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }
        String accessToken = tokenJson.get("access_token").asText();
        String refreshToken = tokenJson.has("refresh_token") ? tokenJson.get("refresh_token").asText() : null;

        TokenResponse tokenResponse = new TokenResponse(accessToken, refreshToken);

        if (redirect != null && !redirect.isBlank()) {
            // set cookie and redirect
            ResponseCookie cookie = ResponseCookie.from("SSO_TOKEN", accessToken)
                    .httpOnly(true)
                    .path("/")
                    .maxAge(3600)
                    .build();
            return ResponseEntity.status(302)
                    .header(HttpHeaders.LOCATION, redirect)
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .build();
        }

        return ResponseEntity.ok(tokenResponse);
    }
    private final PasswordEncoder passwordEncoder;

    public ResponseEntity<?> register(RegisterRequest request)  {
        if (usuarioRepository.findByLogin(request.getLogin()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuario ya existe");
        }
        Persona persona = personaRepository.findById(request.getPersonaId())
            .orElseThrow(() -> new IllegalArgumentException("Persona no encontrada"));
        Estado estado = estadoRepository.findById(request.getEstadoId())
            .orElseThrow(() -> new IllegalArgumentException("Estado no encontrado"));

        Usuario usuario = new Usuario();
        usuario.setLogin(request.getLogin());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setUsuarioDataBase(request.getUsuarioDatabase());
        usuario.setPersona(persona);
        usuario.setEstado(estado);

        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado");
    }
}
