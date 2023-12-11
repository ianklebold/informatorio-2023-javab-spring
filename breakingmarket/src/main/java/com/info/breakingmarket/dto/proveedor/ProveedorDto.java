package com.info.breakingmarket.dto.proveedor;

import com.info.breakingmarket.dto.producto.ProductoDto;
import lombok.Data;

import java.util.List;

@Data
public class ProveedorDto {
    private String nombre;
    private List<ProductoDto> productoDtos;
}
