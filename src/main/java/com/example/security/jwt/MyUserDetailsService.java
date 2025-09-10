package com.example.security.jwt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.CustomUserDetails;
import com.example.usuario.Usuario;
import com.example.usuario.repositories.UsuarioRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Attempting to load user by username: {}", username);
        Usuario usuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> {
                    logger.warn("User not found for username: {}", username);
                    return new UsernameNotFoundException("User not found");
                });

        logger.info("User found: {} (estado: {})", usuario.getLogin(), usuario.getEstado() != null ? usuario.getEstado().getId() : null);
        // Verificación del estado
        if (usuario.getEstado() == null || usuario.getEstado().getId() == 0) {
            logger.warn("User {} is deactivated (estado is null or 0)", usuario.getLogin());
            throw new DisabledException("User account is deactivated.");
        }

        logger.info("Returning CustomUserDetails for user: {}", usuario.getLogin());
        return new CustomUserDetails(usuario);
    }
}


