package com.example.usuario.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Long id;

    @NotBlank(message="La contraseña no puede estar vacía.")
    private String password;

    @NotBlank(message = "El usuario de la base de datos no puede estar vacío.")
    private String usuarioDataBase;

    @NotBlank(message = "El login no puede estar vacío.")
    private String login;

    @NotNull(message="La persona no puede ser nula.")
    private Long personaId;

    @NotNull(message = "El estado no puede ser nulo.")
    private Long estadoId;



}
