package com.example.usuario.mappers;

import com.example.estado.Estado;
import com.example.persona.Persona;
import com.example.usuario.Usuario;
import com.example.usuario.dtos.UsuarioDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T10:12:46-0500",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO.UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.personaId( usuarioPersonaId( usuario ) );
        usuarioDTO.estadoId( usuarioEstadoId( usuario ) );
        usuarioDTO.id( usuario.getId() );
        usuarioDTO.login( usuario.getLogin() );
        usuarioDTO.password( usuario.getPassword() );
        usuarioDTO.usuarioDataBase( usuario.getUsuarioDataBase() );

        return usuarioDTO.build();
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario.UsuarioBuilder usuario = Usuario.builder();

        usuario.persona( usuarioDTOToPersona( usuarioDTO ) );
        usuario.estado( usuarioDTOToEstado( usuarioDTO ) );
        usuario.id( usuarioDTO.getId() );
        usuario.login( usuarioDTO.getLogin() );
        usuario.password( usuarioDTO.getPassword() );
        usuario.usuarioDataBase( usuarioDTO.getUsuarioDataBase() );

        return usuario.build();
    }

    @Override
    public UsuarioDTO toListDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO.UsuarioDTOBuilder usuarioDTO = UsuarioDTO.builder();

        usuarioDTO.personaId( usuarioPersonaId( usuario ) );
        usuarioDTO.estadoId( usuarioEstadoId( usuario ) );
        usuarioDTO.id( usuario.getId() );
        usuarioDTO.login( usuario.getLogin() );
        usuarioDTO.password( usuario.getPassword() );
        usuarioDTO.usuarioDataBase( usuario.getUsuarioDataBase() );

        return usuarioDTO.build();
    }

    private Long usuarioPersonaId(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }
        Persona persona = usuario.getPersona();
        if ( persona == null ) {
            return null;
        }
        Long id = persona.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long usuarioEstadoId(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }
        Estado estado = usuario.getEstado();
        if ( estado == null ) {
            return null;
        }
        Long id = estado.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Persona usuarioDTOToPersona(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Persona.PersonaBuilder persona = Persona.builder();

        persona.id( usuarioDTO.getPersonaId() );

        return persona.build();
    }

    protected Estado usuarioDTOToEstado(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( usuarioDTO.getEstadoId() );

        return estado.build();
    }
}
