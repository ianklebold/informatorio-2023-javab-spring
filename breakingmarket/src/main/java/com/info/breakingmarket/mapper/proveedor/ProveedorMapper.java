package com.info.breakingmarket.mapper.proveedor;

import com.info.breakingmarket.dominio.Proveedor;
import com.info.breakingmarket.dto.proveedor.ProveedorDto;

public class ProveedorMapper {

    public static Proveedor mapToProveedor(ProveedorDto proveedorDto, Proveedor proveedor){
        proveedor.setNombre(proveedorDto.getNombre());
        return proveedor;
    }

    public static ProveedorDto mapToProveedorDto(Proveedor proveedor, ProveedorDto proveedorDto){
        proveedorDto.setNombre(proveedor.getNombre());
        return proveedorDto;
    }

}
