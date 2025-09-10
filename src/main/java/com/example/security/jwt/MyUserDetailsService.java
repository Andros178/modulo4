package com.example.security.jwt;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.estado.repositories.EstadoRepository;
import com.example.security.CustomUserDetails;
import com.example.usuario.Usuario;
import com.example.usuario.repositories.UsuarioRepository;



@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Verificación del estado
        if (usuario.getEstado() == null || usuario.getEstado().getId() == 0) {
            throw new DisabledException("User account is deactivated.");
        }

        return new CustomUserDetails(usuario);
    }
}


