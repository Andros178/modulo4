package com.example.persona.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    private Long id;

    @NotNull(message = "La cedula no puede ser nula.")
    private Long cedula;
    
    @NotBlank(message = "El nombre de la persona no puede estar vacío.")
    @Size(max = 100, message = "El nombre de la persona no puede exceder los 100 carácteres.")
    private String nombre;

    @NotBlank(message = "El apellido de la persona  no puede estar vacío.")
    @Size(max = 100, message = "El apellido de la persona no puede exceder los 100 carácteres.")
    private String apellido;

    @NotBlank(message = "El correo no puede estar vacío")
    @Size(max = 100, message = "El correo no puede exceder los 100 carácteres.")
    private String correo;
    @NotNull(message = "El estado no puede ser nulo.")
    private Long estadoId;
}
