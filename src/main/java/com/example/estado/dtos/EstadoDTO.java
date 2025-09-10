package com.example.estado.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoDTO {

    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio.")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres.")
    private String nombre;
    
    @Size(max = 2048, message = "La descripción no puede exceder los 2048 carácteres,")
    private String descripcion;
}
