package com.info.breakingmarket.service.categoria;

import com.info.breakingmarket.dominio.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> obtenerCategoriaPorIds(List<Long> idCategorias);
}
