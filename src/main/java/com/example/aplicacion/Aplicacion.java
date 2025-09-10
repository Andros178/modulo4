package com.example.aplicacion;

import com.example.estado.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "aplicacion", schema = "public")
public class Aplicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aplicacion_generator")
    @SequenceGenerator(name = "aplicacion_generator", sequenceName = "aplicacion_app_id_seq", allocationSize = 1)
    @Column(name = "app_id", nullable = false)
    private Long id;
    
    @Column(name = "app_nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "app_acronimo", nullable = false, length = 100)
    private String acronimo;

    @Column(name = "app_descripcion",length = 2048)
    private String descripcion;
    
    @Column(name = "app_url", nullable = false, length = 1024)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_estado_id", referencedColumnName = "est_id", nullable = false)
    private Estado estado;
}
