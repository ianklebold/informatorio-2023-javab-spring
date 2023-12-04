package com.info.breakingmarket.repository.producto;

import com.info.breakingmarket.dominio.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, UUID>{



}
