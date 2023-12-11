package com.info.breakingmarket.service.producto.impl;

import com.info.breakingmarket.dominio.Producto;
import com.info.breakingmarket.dominio.Proveedor;
import com.info.breakingmarket.dto.producto.ProductoDto;
import com.info.breakingmarket.mapper.producto.ProductoMapper;
import com.info.breakingmarket.repository.producto.ProductoRepository;
import com.info.breakingmarket.service.categoria.CategoriaService;
import com.info.breakingmarket.service.producto.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    private final CategoriaService categoriaService;
    @Override
    public List<Producto> crearProductos(List<ProductoDto> productos, Proveedor proveedor) {
        ProductoMapper.mapToProductos(productos,proveedor.getProductos());

        for (int i = 0; i < productos.size(); i++) {
            proveedor.getProductos().get(i).setCategorias(
                    categoriaService.obtenerCategoriaPorIds(productos.get(i).getCategorias())
            );
            proveedor.getProductos().get(i).setId(UUID.randomUUID());
            proveedor.getProductos().get(i).setCreadoPor("Anonimo");
            proveedor.getProductos().get(i).setCreadoEn(LocalDateTime.now());
            proveedor.getProductos().get(i).setProveedor(proveedor);
        }

        return productoRepository.saveAll(proveedor.getProductos());
    }

    @Override
    public boolean eliminarProductos(List<Producto> productos) {
        productoRepository.deleteAll(productos);
        return Boolean.TRUE;
    }
}
