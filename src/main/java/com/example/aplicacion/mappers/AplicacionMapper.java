package com.example.aplicacion.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.aplicacion.Aplicacion;
import com.example.aplicacion.dtos.AplicacionDTO;

@Mapper(componentModel = "spring")
public interface AplicacionMapper {
    @Mapping(source = "estado.id", target = "estadoId")
    AplicacionDTO toDto(Aplicacion aplicacion);

    @Mapping(source = "estadoId", target = "estado.id")
    Aplicacion toEntity(AplicacionDTO aplicacionDTO);
}
