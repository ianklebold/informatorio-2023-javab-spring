package com.info.breakingmarket.service.proveedor.impl;

import com.info.breakingmarket.dominio.Proveedor;
import com.info.breakingmarket.dto.proveedor.ProveedorDto;
import com.info.breakingmarket.exception.NotFoundException;
import com.info.breakingmarket.mapper.producto.ProductoMapper;
import com.info.breakingmarket.mapper.proveedor.ProveedorMapper;
import com.info.breakingmarket.repository.proveedor.ProveedorRepository;
import com.info.breakingmarket.service.producto.ProductoService;
import com.info.breakingmarket.service.proveedor.ProveedorService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProvedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    private final ProductoService productoService;

    @Transactional
    @Override
    public void crearProveedorConProductos(ProveedorDto proveedorDto) {
        Proveedor nuevoProveedor = ProveedorMapper.mapToProveedor(proveedorDto,new Proveedor());
        nuevoProveedor.setId(UUID.randomUUID());
        nuevoProveedor.setCreadoPor("Anonimo");
        nuevoProveedor.setCreadoEn(LocalDateTime.now());

        proveedorRepository.save(nuevoProveedor);
        productoService.crearProductos(proveedorDto.getProductoDtos(),nuevoProveedor);
    }

    @Override
    public ProveedorDto obtenerProveedorPorId(UUID idProveedor) {
        Proveedor proveedor = proveedorRepository.findById(idProveedor)
                .orElseThrow(() -> new NotFoundException("Proveedor","idProveedor",idProveedor.toString())  );

        ProveedorDto proveedorDto = ProveedorMapper.mapToProveedorDto(proveedor, new ProveedorDto());
        proveedorDto.setProductoDtos(ProductoMapper.mapToProductoDtos(proveedor.getProductos(), new ArrayList<>()));

        return proveedorDto;
    }

    @Override
    public boolean eliminarProveedorPorId(UUID uuid) {
        Proveedor proveedor = proveedorRepository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Proveedor","idProveedor",uuid.toString()));

        productoService.eliminarProductos(proveedor.getProductos());
        proveedorRepository.delete(proveedor);

        return Boolean.TRUE;
    }
}
