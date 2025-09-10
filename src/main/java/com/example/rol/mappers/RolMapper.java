package com.example.rol.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.rol.Rol;
import com.example.rol.dtos.RolDTO;

@Mapper(componentModel = "spring")
public interface RolMapper {
    @Mapping(source = "estado.id", target = "estadoId")
    RolDTO toDto(Rol rol);

    @Mapping(source = "estadoId", target = "estado.id")
    Rol toEntity(RolDTO rolDTO);

    
}
