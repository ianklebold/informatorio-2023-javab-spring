package com.info.breakingmarket.service.proveedor;

import com.info.breakingmarket.dto.proveedor.ProveedorDto;

import java.util.UUID;

public interface ProveedorService {
    void crearProveedorConProductos(ProveedorDto proveedorDto);

    ProveedorDto obtenerProveedorPorId(UUID idProveedor);

    boolean eliminarProveedorPorId(UUID uuid);

}
