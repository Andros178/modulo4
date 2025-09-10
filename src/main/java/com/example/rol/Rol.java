package com.example.rol;

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
@Table(name = "rol", schema = "public")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_generator")
    @SequenceGenerator(name = "rol_generator", sequenceName = "rol_rol_id_seq", allocationSize = 1)
    @Column(name="rol_id", nullable=false)
    private Long id;

    @Column(name = "rol_nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "rol_descripcion", nullable = false, length = 2048)
    private String descripcion;

    @Column(name = "rol_acronimo", nullable = false, length = 100)
    private String acronimo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rol_estado_id",referencedColumnName = "est_id", nullable = false)
    private Estado estado;

}
