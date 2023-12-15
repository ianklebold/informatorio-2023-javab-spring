package com.info.breakingmarket.service.producto.impl;

import com.info.breakingmarket.dominio.Producto;
import com.info.breakingmarket.dominio.Proveedor;
import com.info.breakingmarket.dto.producto.ProductoDto;
import com.info.breakingmarket.exception.NotFoundException;
import com.info.breakingmarket.mapper.producto.ProductoMapper;
import com.info.breakingmarket.repository.producto.ProductoRepository;
import com.info.breakingmarket.service.categoria.CategoriaService;
import com.info.breakingmarket.service.producto.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Override
    public boolean actualizarProducto(UUID idProducto, ProductoDto productoDto) {

        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new NotFoundException("Producto","idProducto",idProducto.toString())  );

        ProductoMapper.mapToProducto(productoDto,producto);
        productoRepository.save(producto);

        return Boolean.TRUE;
    }

    @Override
    public List<ProductoDto> obtenerTodosLosProductos(String nombreProducto, String stock) {

        if (Integer.parseInt(stock) > 0 && !ObjectUtils.isEmpty(nombreProducto)){
            //Query method para filtro por stock y nombre
            return ProductoMapper.mapToProductoDtos(productoRepository.findByNombreStartingWithAndStockGreaterThan(nombreProducto,Integer.parseInt(stock)),new ArrayList<>());
        }else if (!ObjectUtils.isEmpty(nombreProducto)){
            return ProductoMapper.mapToProductoDtos(productoRepository.findByNombreStartingWith(nombreProducto),new ArrayList<>());
        }
        // Query method para filtro por stock
        return ProductoMapper.mapToProductoDtos(productoRepository.findByStockGreaterThan(Integer.parseInt(stock)),new ArrayList<>());
    }
}
