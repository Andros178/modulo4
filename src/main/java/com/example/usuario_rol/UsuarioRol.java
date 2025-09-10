package com.example.usuario_rol;

import com.example.aplicacion.Aplicacion;
import com.example.estado.Estado;
import com.example.rol.Rol;
import com.example.usuario.Usuario;

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
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario_rol", schema = "public")
public class UsuarioRol {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarioRol_generator")
    @SequenceGenerator(name = "usuarioRol_generator",sequenceName = "usuario_rol_usr_id_seq", allocationSize = 1 )
    @Column(name="usr_id", nullable=false)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_usuario_id", referencedColumnName = "usr_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_rol_id", referencedColumnName = "rol_id", nullable = false)
    private Rol rol;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_estado_id", referencedColumnName = "est_id", nullable = false)
    private Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usr_aplicacion_id", referencedColumnName = "app_id", nullable = false)
    private Aplicacion aplicacion;


}
