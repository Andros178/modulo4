package com.example.usuario.services;

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
    
    
}
