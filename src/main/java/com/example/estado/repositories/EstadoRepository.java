package com.example.estado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estado.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    
}