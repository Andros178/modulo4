package com.example.usuario_rol.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.estado.repositories.EstadoRepository;
import com.example.usuario_rol.dtos.UsuarioRolDTO;
import com.example.usuario_rol.mappers.UsuarioRolMapper;
import com.example.usuario_rol.repositories.UsuarioRolRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioRolService {
    private final UsuarioRolRepository usuarioRolRepository;
    private final UsuarioRolMapper usuarioRolMapper;
    private final EstadoRepository estadoRepository;
    
    
    
    
}
