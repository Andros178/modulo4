package com.example.security;

import com.example.keycloak.KeycloakTokenService;
import com.example.keycloak.dtos.TokenResponse;
import com.example.loginRequest.LoginRequest;
import com.example.usuario.Usuario;
import com.example.usuario.repositories.UsuarioRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final KeycloakTokenService keycloakTokenService;

    public ResponseEntity<TokenResponse> login(LoginRequest request) {
        // 1) Autenticar contra tu BD usando Spring Security
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // 2) Validar usuario en BD
        Usuario usuario = usuarioRepository.findByLogin(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no existe en BD"));

        // 3) Obtener token desde Keycloak (Direct Access Grant)
        JsonNode tokenJson = keycloakTokenService.directGrant(request.getUsername(), request.getPassword());

        if (tokenJson == null || !tokenJson.has("access_token")) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }

        String accessToken = tokenJson.get("access_token").asText();
        String refreshToken = tokenJson.has("refresh_token")
                ? tokenJson.get("refresh_token").asText()
                : null;

        return ResponseEntity.ok(new TokenResponse(accessToken, refreshToken));
    }
}
