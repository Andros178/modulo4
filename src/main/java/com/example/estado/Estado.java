package com.example.estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "estado", schema = "public")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado_generator")
    @SequenceGenerator(name = "estado_generator", sequenceName = "estado_est_id_seq", allocationSize = 1)
    @Column(name="est_id", nullable=false)
    private Long id;
    
    @Column(name = "est_nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "est_descripcion", length = 2048)
    private String descripcion;
    
}
