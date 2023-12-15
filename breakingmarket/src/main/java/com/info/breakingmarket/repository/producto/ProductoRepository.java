package com.info.breakingmarket.repository.producto;

import com.info.breakingmarket.dominio.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, UUID>{

        //Query method
        List<Producto> findByNombreStartingWith(String nombre);

        // Query method para filtro por stock
        List<Producto> findByStockGreaterThan(int stock);

        List<Producto> findByNombreStartingWithAndStockGreaterThan(String nombre, int stock);
}
