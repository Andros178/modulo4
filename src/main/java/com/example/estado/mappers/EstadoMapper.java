package com.example.estado.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.estado.Estado;
import com.example.estado.dtos.EstadoDTO;

@Mapper(componentModel = "spring")
public interface EstadoMapper {
    @Mapping(target = "descripcion", ignore = true)
	@Mapping(target = "id", source = "id")
	@Mapping(target = "nombre", source = "nombre")
	EstadoDTO toShortDTO(Estado estado);
}
