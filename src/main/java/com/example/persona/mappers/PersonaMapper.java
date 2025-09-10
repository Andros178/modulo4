package com.example.persona.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.persona.Persona;
import com.example.persona.dtos.PersonaDTO;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    @Mapping(source = "estado.id", target = "estadoId")
    PersonaDTO toDto (Persona persona);

    
    @Mapping(source = "estadoId", target = "estado.id")
    Persona toEntity(PersonaDTO personaDTO);
}
