package com.info.breakingmarket.mapper.categoria;

import com.info.breakingmarket.dominio.Categoria;
import com.info.breakingmarket.dto.categoria.CategoriaDto;

import java.util.List;

public class CategoriaMapper {
    public static CategoriaDto mapToCategoriaDto(Categoria categoria, CategoriaDto categoriaDto){
        categoriaDto.setId(categoria.getId());
        categoriaDto.setNombre(categoriaDto.getNombre());
        return categoriaDto;
    }

    public static List<CategoriaDto> mapToCategoriasDtos(List<Categoria> categorias, List<CategoriaDto> categoriaDtos){
        for (Categoria categoria: categorias
        ) {
            categoriaDtos.add(mapToCategoriaDto(categoria,new CategoriaDto()));
        }
        return categoriaDtos;
    }
}
