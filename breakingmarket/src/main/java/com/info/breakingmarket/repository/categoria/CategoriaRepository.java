package com.info.breakingmarket.repository.categoria;

import com.info.breakingmarket.dominio.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
