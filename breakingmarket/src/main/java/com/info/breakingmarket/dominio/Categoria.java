package com.info.breakingmarket.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "native")
    private Long id;

    private String nombre;

    @ManyToMany
    @JoinTable(name = "producto_categoria", joinColumns = @JoinColumn(name = "categoria_id"),
    inverseJoinColumns = @JoinColumn(name = "producto_id"))
    private List<Producto> productos = new ArrayList<>();
}
