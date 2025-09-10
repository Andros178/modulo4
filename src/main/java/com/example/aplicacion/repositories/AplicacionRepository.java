package com.example.aplicacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estado.Estado;

@Repository
public interface AplicacionRepository extends JpaRepository <Estado, Long> {
    
    
}
