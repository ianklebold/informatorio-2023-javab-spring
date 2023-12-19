package com.info.breakingmarket.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoriaDto {

    @NotNull(message = "El id de la categoria no puede ser nula")
    private Long id;

    @NotBlank(message = "Nombre de la categoria no puede ser nulo o vacio")
    private String nombre;
}
