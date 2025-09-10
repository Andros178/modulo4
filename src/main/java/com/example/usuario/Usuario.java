package com.example.usuario;

import java.util.HashSet;
import java.util.Set;

import com.example.estado.Estado;
import com.example.persona.Persona;
import com.example.rol.Rol;
import com.example.usuario_rol.UsuarioRol;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "usuario", schema = "public")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_generator")
    @SequenceGenerator(name = "usuario_generator", sequenceName = "usuario_usr_id_seq", allocationSize = 1)
    @Column(name = "usr_id", nullable = false)
    private Long id;

    @Column(name = "usr_password", nullable = false)
    private String password;

    @Column(name = "usr_database_usuario", nullable = false, length = 100)
    private String usuarioDataBase;

    @Column(name = "usr_login", nullable = false, length = 100)
    private String login;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_persona_id", referencedColumnName = "per_id", nullable = false)
    private Persona persona; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_estado_id", referencedColumnName = "est_id", nullable = false)
    private Estado estado;

    @Builder.Default
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();
}


