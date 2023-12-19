package com.info.breakingmarket.dto.producto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductoDto {

    @NotBlank(message = "Nombre del producto no puede ser nulo o vacio")
    private String nombre;

    @NotNull(message = "El precio no puede ser nulo")
    @Positive
    private Double precio;

    @NotNull(message = "El stock del producto no puede ser nulo")
    @Min(value = 0)
    private int stock;

    @NotBlank(message = "La descripcion del producto no puede ser nulo o vacio")
    private String descripcion;

    private List<Long> categorias = new ArrayList<>();
}
