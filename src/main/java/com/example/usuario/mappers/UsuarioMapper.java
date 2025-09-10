package com.example.usuario.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.usuario.Usuario;
import com.example.usuario.dtos.UsuarioDTO;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping (source = "persona.id", target = "personaId")
    @Mapping (source = "estado.id", target = "estadoId")
    UsuarioDTO toDto(Usuario usuario);

    @Mapping (source = "personaId", target = "persona.id")
    @Mapping (source = "estadoId", target = "estado.id")
    Usuario toEntity(UsuarioDTO usuarioDTO);

    @Mapping (source= "persona.id", target="personaId")
    @Mapping (source = "estado.id", target = "estadoId")
    UsuarioDTO toListDTO(Usuario usuario);
}
