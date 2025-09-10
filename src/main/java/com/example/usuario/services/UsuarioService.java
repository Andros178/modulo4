package com.example.usuario.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.estado.repositories.EstadoRepository;
import com.example.usuario.mappers.UsuarioMapper;
import com.example.usuario.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final EstadoRepository estadoRepository;
    private final PasswordEncoder passwordEncoder;
    // Método para registrar un usuario
    public com.example.usuario.Usuario registrarUsuario(String login, String password) {
        if (usuarioRepository.findByLogin(login).isPresent()) {
            throw new IllegalArgumentException("El usuario ya existe");
        }
        com.example.usuario.Usuario usuario = new com.example.usuario.Usuario();
        usuario.setLogin(login);
        usuario.setPassword(passwordEncoder.encode(password));
        // Puedes setear otros campos aquí si es necesario
        return usuarioRepository.save(usuario);
    }
}
