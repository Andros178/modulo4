package com.example.aplicacion.mappers;

import com.example.aplicacion.Aplicacion;
import com.example.aplicacion.dtos.AplicacionDTO;
import com.example.estado.Estado;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T10:12:46-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class AplicacionMapperImpl implements AplicacionMapper {

    @Override
    public AplicacionDTO toDto(Aplicacion aplicacion) {
        if ( aplicacion == null ) {
            return null;
        }

        AplicacionDTO.AplicacionDTOBuilder aplicacionDTO = AplicacionDTO.builder();

        aplicacionDTO.estadoId( aplicacionEstadoId( aplicacion ) );
        aplicacionDTO.acronimo( aplicacion.getAcronimo() );
        aplicacionDTO.descripcion( aplicacion.getDescripcion() );
        aplicacionDTO.id( aplicacion.getId() );
        aplicacionDTO.nombre( aplicacion.getNombre() );
        aplicacionDTO.url( aplicacion.getUrl() );

        return aplicacionDTO.build();
    }

    @Override
    public Aplicacion toEntity(AplicacionDTO aplicacionDTO) {
        if ( aplicacionDTO == null ) {
            return null;
        }

        Aplicacion.AplicacionBuilder aplicacion = Aplicacion.builder();

        aplicacion.estado( aplicacionDTOToEstado( aplicacionDTO ) );
        aplicacion.acronimo( aplicacionDTO.getAcronimo() );
        aplicacion.descripcion( aplicacionDTO.getDescripcion() );
        aplicacion.id( aplicacionDTO.getId() );
        aplicacion.nombre( aplicacionDTO.getNombre() );
        aplicacion.url( aplicacionDTO.getUrl() );

        return aplicacion.build();
    }

    private Long aplicacionEstadoId(Aplicacion aplicacion) {
        if ( aplicacion == null ) {
            return null;
        }
        Estado estado = aplicacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        Long id = estado.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Estado aplicacionDTOToEstado(AplicacionDTO aplicacionDTO) {
        if ( aplicacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( aplicacionDTO.getEstadoId() );

        return estado.build();
    }
}
