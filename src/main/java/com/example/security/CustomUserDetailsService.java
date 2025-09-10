package com.example.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.usuario.repositories.UsuarioRepository;
import com.example.usuario.Usuario;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + login));

        // Extraer roles desde usuarioRoles -> rol.nombre
        List<SimpleGrantedAuthority> authorities = usuario.getUsuarioRoles().stream()
                .map(usuarioRol -> new SimpleGrantedAuthority(usuarioRol.getRol().getAcronimo().toUpperCase()))
                .toList();

        return new org.springframework.security.core.userdetails.User(
                usuario.getLogin(),
                usuario.getPassword(),
                authorities
        );
    }
}
