package com.info.breakingmarket.dto.producto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductoDto {
    private String nombre;
    private Double precio;
    private int stock;
    private String descripcion;
    private List<Long> categorias = new ArrayList<>();
}
