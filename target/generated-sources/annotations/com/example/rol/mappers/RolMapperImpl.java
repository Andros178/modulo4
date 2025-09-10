package com.example.rol.mappers;

import com.example.estado.Estado;
import com.example.rol.Rol;
import com.example.rol.dtos.RolDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T10:12:46-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class RolMapperImpl implements RolMapper {

    @Override
    public RolDTO toDto(Rol rol) {
        if ( rol == null ) {
            return null;
        }

        RolDTO.RolDTOBuilder rolDTO = RolDTO.builder();

        rolDTO.estadoId( rolEstadoId( rol ) );
        rolDTO.acronimo( rol.getAcronimo() );
        rolDTO.descripcion( rol.getDescripcion() );
        rolDTO.id( rol.getId() );
        rolDTO.nombre( rol.getNombre() );

        return rolDTO.build();
    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        if ( rolDTO == null ) {
            return null;
        }

        Rol.RolBuilder rol = Rol.builder();

        rol.estado( rolDTOToEstado( rolDTO ) );
        rol.acronimo( rolDTO.getAcronimo() );
        rol.descripcion( rolDTO.getDescripcion() );
        rol.id( rolDTO.getId() );
        rol.nombre( rolDTO.getNombre() );

        return rol.build();
    }

    private Long rolEstadoId(Rol rol) {
        if ( rol == null ) {
            return null;
        }
        Estado estado = rol.getEstado();
        if ( estado == null ) {
            return null;
        }
        Long id = estado.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Estado rolDTOToEstado(RolDTO rolDTO) {
        if ( rolDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( rolDTO.getEstadoId() );

        return estado.build();
    }
}
