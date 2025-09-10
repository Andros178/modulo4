package com.example.usuario_rol.mappers;

import com.example.aplicacion.Aplicacion;
import com.example.estado.Estado;
import com.example.rol.Rol;
import com.example.usuario.Usuario;
import com.example.usuario_rol.UsuarioRol;
import com.example.usuario_rol.dtos.UsuarioRolDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T10:12:46-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class UsuarioRolMapperImpl implements UsuarioRolMapper {

    @Override
    public UsuarioRolDTO toDto(UsuarioRol usuarioRol) {
        if ( usuarioRol == null ) {
            return null;
        }

        UsuarioRolDTO.UsuarioRolDTOBuilder usuarioRolDTO = UsuarioRolDTO.builder();

        usuarioRolDTO.usuarioId( usuarioRolUsuarioId( usuarioRol ) );
        usuarioRolDTO.rolId( usuarioRolRolId( usuarioRol ) );
        usuarioRolDTO.aplicacionId( usuarioRolAplicacionId( usuarioRol ) );
        usuarioRolDTO.estadoId( usuarioRolEstadoId( usuarioRol ) );
        usuarioRolDTO.id( usuarioRol.getId() );

        return usuarioRolDTO.build();
    }

    @Override
    public UsuarioRol toEntity(UsuarioRolDTO usuarioRolDTO) {
        if ( usuarioRolDTO == null ) {
            return null;
        }

        UsuarioRol.UsuarioRolBuilder usuarioRol = UsuarioRol.builder();

        usuarioRol.usuario( usuarioRolDTOToUsuario( usuarioRolDTO ) );
        usuarioRol.rol( usuarioRolDTOToRol( usuarioRolDTO ) );
        usuarioRol.aplicacion( usuarioRolDTOToAplicacion( usuarioRolDTO ) );
        usuarioRol.estado( usuarioRolDTOToEstado( usuarioRolDTO ) );
        usuarioRol.id( usuarioRolDTO.getId() );

        return usuarioRol.build();
    }

    private Long usuarioRolUsuarioId(UsuarioRol usuarioRol) {
        if ( usuarioRol == null ) {
            return null;
        }
        Usuario usuario = usuarioRol.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        Long id = usuario.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long usuarioRolRolId(UsuarioRol usuarioRol) {
        if ( usuarioRol == null ) {
            return null;
        }
        Rol rol = usuarioRol.getRol();
        if ( rol == null ) {
            return null;
        }
        Long id = rol.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long usuarioRolAplicacionId(UsuarioRol usuarioRol) {
        if ( usuarioRol == null ) {
            return null;
        }
        Aplicacion aplicacion = usuarioRol.getAplicacion();
        if ( aplicacion == null ) {
            return null;
        }
        Long id = aplicacion.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long usuarioRolEstadoId(UsuarioRol usuarioRol) {
        if ( usuarioRol == null ) {
            return null;
        }
        Estado estado = usuarioRol.getEstado();
        if ( estado == null ) {
            return null;
        }
        Long id = estado.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Usuario usuarioRolDTOToUsuario(UsuarioRolDTO usuarioRolDTO) {
        if ( usuarioRolDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.id( usuarioRolDTO.getUsuarioId() );

        return usuario.build();
    }

    protected Rol usuarioRolDTOToRol(UsuarioRolDTO usuarioRolDTO) {
        if ( usuarioRolDTO == null ) {
            return null;
        }

        Rol.RolBuilder rol = Rol.builder();

        rol.id( usuarioRolDTO.getRolId() );

        return rol.build();
    }

    protected Aplicacion usuarioRolDTOToAplicacion(UsuarioRolDTO usuarioRolDTO) {
        if ( usuarioRolDTO == null ) {
            return null;
        }

        Aplicacion.AplicacionBuilder aplicacion = Aplicacion.builder();

        aplicacion.id( usuarioRolDTO.getAplicacionId() );

        return aplicacion.build();
    }

    protected Estado usuarioRolDTOToEstado(UsuarioRolDTO usuarioRolDTO) {
        if ( usuarioRolDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( usuarioRolDTO.getEstadoId() );

        return estado.build();
    }
}
