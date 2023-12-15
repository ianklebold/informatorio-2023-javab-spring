package com.info.breakingmarket.service.producto;

import com.info.breakingmarket.dominio.Producto;
import com.info.breakingmarket.dominio.Proveedor;
import com.info.breakingmarket.dto.producto.ProductoDto;

import java.util.List;
import java.util.UUID;

public interface ProductoService {
    List<Producto> crearProductos(List<ProductoDto> productos, Proveedor proveedor);

    boolean eliminarProductos(List<Producto> productos);

    boolean actualizarProducto(UUID idProducto, ProductoDto productoDto);

    List<ProductoDto> obtenerTodosLosProductos(String nombreProducto, String stock);

}
