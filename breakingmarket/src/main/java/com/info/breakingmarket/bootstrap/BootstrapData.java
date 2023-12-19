package com.info.breakingmarket.bootstrap;

import com.info.breakingmarket.dominio.Categoria;
import com.info.breakingmarket.dominio.Producto;
import com.info.breakingmarket.dominio.Proveedor;
import com.info.breakingmarket.repository.categoria.CategoriaRepository;
import com.info.breakingmarket.repository.producto.ProductoRepository;
import com.info.breakingmarket.repository.proveedor.ProveedorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private CategoriaRepository categoriaRepository;
    private ProductoRepository productoRepository;
    private ProveedorRepository proveedorRepository;

    @Override
    public void run(String... args) throws Exception {
        cargarCategorias();
        cargarProveedor();
        cargarProductos();
    }

    private void cargarCategorias(){
        if (categoriaRepository.count() == 0){
            Categoria categoria = new Categoria();
            categoria.setId(1L);
            categoria.setNombre("Categoria Prueba");

            categoriaRepository.save(categoria);
        }
    }

    private void cargarProveedor(){
        if (proveedorRepository.count() == 0){
            Proveedor proveedor = new Proveedor();
            proveedor.setId(UUID.randomUUID());
            proveedor.setNombre("Proveedor prueba");
            proveedor.setCreadoPor("Anonimo");
            proveedor.setCreadoEn(LocalDateTime.now());

            proveedorRepository.save(proveedor);
        }
    }

    private void cargarProductos(){
        if (productoRepository.count() == 0){
            Producto producto = new Producto();
            producto.setId(UUID.randomUUID());
            producto.setNombre("Producto prueba");
            producto.setDescripcion("Descripcion del producto");
            producto.setCategorias(List.of(categoriaRepository.findById(1L).get()));
            producto.setStock(100);
            producto.setPrecio(50d);
            producto.setCreadoPor("Anonimo");
            producto.setCreadoEn(LocalDateTime.now());


            for (Proveedor proveedor:proveedorRepository.findAll()) {
                proveedor.getProductos().add(producto);
                producto.setProveedor(proveedor);
                productoRepository.save(producto);
            }
        }
    }


}
