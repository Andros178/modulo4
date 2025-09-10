package com.example.estado.mappers;

import com.example.estado.Estado;
import com.example.estado.dtos.EstadoDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T10:12:46-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class EstadoMapperImpl implements EstadoMapper {

    @Override
    public EstadoDTO toShortDTO(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        EstadoDTO.EstadoDTOBuilder estadoDTO = EstadoDTO.builder();

        estadoDTO.id( estado.getId() );
        estadoDTO.nombre( estado.getNombre() );

        return estadoDTO.build();
    }
}
