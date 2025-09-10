package com.example.persona;

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
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persona", schema = "public")
public class Persona {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="persona_generator")
    @SequenceGenerator(name = "persona_generator", sequenceName = "persona_per_id_seq", allocationSize = 1)
    @Column(name = "per_id", nullable = false)
    private Long id;
    
    @Column(name = "per_cedula", nullable = false, length = 100)
    private Long cedula;    

    @Column(name = "per_nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "per_apellido", nullable = false, length = 100)
    private String apellido;

    @Email
    @Column(name = "per_correo", nullable = false, length = 100)
    private String correo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "per_estado_id", referencedColumnName = "est_id", nullable = false)
    private Estado estado;
}
