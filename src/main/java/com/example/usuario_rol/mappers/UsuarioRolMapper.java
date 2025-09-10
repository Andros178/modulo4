package com.example.usuario_rol.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.usuario_rol.UsuarioRol;
import com.example.usuario_rol.dtos.UsuarioRolDTO;

@Mapper(componentModel = "spring")
public interface UsuarioRolMapper {
    @Mapping(source = "usuario.id", target = "usuarioId")
    @Mapping(source = "rol.id",target = "rolId")
    @Mapping (source= "aplicacion.id", target="aplicacionId")
    @Mapping(source = "estado.id", target = "estadoId")
    UsuarioRolDTO toDto(UsuarioRol usuarioRol);

    @Mapping(source = "usuarioId", target = "usuario.id")
    @Mapping(source = "rolId", target = "rol.id")
    @Mapping(source = "aplicacionId", target = "aplicacion.id")
    @Mapping(source = "estadoId", target = "estado.id")
    UsuarioRol toEntity(UsuarioRolDTO usuarioRolDTO);

}
