package com.example.aplicacion.dtos;

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
public class AplicacionDTO {
    private Long id;

    @NotBlank(message = "El nombre no puede estár vacío.")
    @Size(max = 100, message = "El nombre no puede exceder los 100 carácteres.")
    private String nombre;

    @NotBlank(message = "El acronimo no puede estár vacío.")
    @Size(max = 100, message = "El acronimo no puede exceder los 100 carácteres.")
    private String acronimo;

    @NotBlank(message = "La url no puede estár vacío.")
    @Size(max = 100, message = "La url no peude exceder los 100 carácteres.")
    private String url;

    @Size(max = 2048, message = "La descripción no puede exceder los 2048.")
    private String descripcion;

    @NotNull(message = "El estado no puede ser nulo.")
    private Long estadoId;
}
