package com.info.breakingmarket.service.categoria.impl;

import com.info.breakingmarket.dominio.Categoria;
import com.info.breakingmarket.repository.categoria.CategoriaRepository;
import com.info.breakingmarket.service.categoria.CategoriaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> obtenerCategoriaPorIds(List<Long> idCategorias) {
        List<Categoria> categorias = new ArrayList<>();
        for (Long idCategoria: idCategorias) {
            Categoria categoria = categoriaRepository.findById(idCategoria)
                    .orElseThrow( () -> new RuntimeException("No existe el recurso") );
            categorias.add(categoria);
        }
        return categorias;
    }
}
