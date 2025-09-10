package com.example.persona.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.persona.Persona;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long> {
    
}
