package com.example.usuario_rol.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRolDTO {
    private Long id;
    
    @NotNull(message = "El usuario no puede ser nulo.")
    private Long usuarioId;

    @NotNull(message = "El rol no puede ser nulo.")
    private Long rolId;

    @NotNull(message = "La aplicación no puede ser nula.")
    private Long aplicacionId;

    @NotNull(message = "El estado no puede ser nulo.")
    private Long estadoId;

}
