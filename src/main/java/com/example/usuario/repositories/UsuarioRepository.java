package com.example.usuario.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.usuario.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    List<Usuario> findByEstadoIdOrderByIdAsc (Long estadoId);
    Optional<Usuario> findByLogin (String login);
    List<Usuario> findByLoginAndEstadoId (String login, Long estadoId);
    
}
