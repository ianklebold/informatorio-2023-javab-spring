package com.info.breakingmarket.mapper.producto;

import com.info.breakingmarket.dominio.Producto;
import com.info.breakingmarket.dto.producto.ProductoDto;

import java.util.Collection;
import java.util.List;

public class ProductoMapper {
    public static Producto mapToProducto(ProductoDto productoDto, Producto producto){
        producto.setNombre(productoDto.getNombre());
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        producto.setStock(productoDto.getStock());

        return producto;
    }

    public static List<Producto> mapToProductos(Collection<ProductoDto> productoDtos, Collection<Producto> productos){
        for (ProductoDto productoDto: productoDtos) {
            productos.add(
                    mapToProducto(productoDto,new Producto())
            );
        }
        return (List<Producto>) productos;
    }

    public static ProductoDto mapToProductoDto(Producto producto,ProductoDto productoDto){
        productoDto.setNombre(producto.getNombre());
        productoDto.setDescripcion(producto.getDescripcion());
        productoDto.setStock(producto.getStock());
        productoDto.setPrecio(producto.getPrecio());

        return productoDto;
    }

    public static List<ProductoDto> mapToProductoDtos(Collection<Producto> productos ,Collection<ProductoDto> productoDtos){
        for (Producto producto: productos) {
            productoDtos.add(
                    mapToProductoDto(producto,new ProductoDto())
            );
        }
        return (List<ProductoDto>) productoDtos;
    }
}
