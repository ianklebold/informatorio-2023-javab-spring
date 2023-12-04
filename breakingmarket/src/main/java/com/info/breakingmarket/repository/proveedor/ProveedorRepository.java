package com.info.breakingmarket.repository.proveedor;

import com.info.breakingmarket.dominio.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, UUID> {
}
