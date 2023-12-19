package com.info.breakingmarket.dto.proveedor;

import com.info.breakingmarket.dto.producto.ProductoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class ProveedorDto {

    @NotBlank(message = "El nombre del proveedor no puede ser nulo o vacio")
    private String nombre;

    @Valid
    private List<ProductoDto> productoDtos;
}
