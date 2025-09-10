package com.example.persona.mappers;

import com.example.estado.Estado;
import com.example.persona.Persona;
import com.example.persona.dtos.PersonaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T10:12:46-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaDTO toDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaDTO.PersonaDTOBuilder personaDTO = PersonaDTO.builder();

        personaDTO.estadoId( personaEstadoId( persona ) );
        personaDTO.apellido( persona.getApellido() );
        personaDTO.cedula( persona.getCedula() );
        personaDTO.correo( persona.getCorreo() );
        personaDTO.id( persona.getId() );
        personaDTO.nombre( persona.getNombre() );

        return personaDTO.build();
    }

    @Override
    public Persona toEntity(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        Persona.PersonaBuilder persona = Persona.builder();

        persona.estado( personaDTOToEstado( personaDTO ) );
        persona.apellido( personaDTO.getApellido() );
        persona.cedula( personaDTO.getCedula() );
        persona.correo( personaDTO.getCorreo() );
        persona.id( personaDTO.getId() );
        persona.nombre( personaDTO.getNombre() );

        return persona.build();
    }

    private Long personaEstadoId(Persona persona) {
        if ( persona == null ) {
            return null;
        }
        Estado estado = persona.getEstado();
        if ( estado == null ) {
            return null;
        }
        Long id = estado.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Estado personaDTOToEstado(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( personaDTO.getEstadoId() );

        return estado.build();
    }
}
