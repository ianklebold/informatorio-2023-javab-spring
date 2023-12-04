package com.info.breakingmarket.dominio;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto extends EntidadBase{

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36,columnDefinition = "varchar(36)",updatable = false,nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    private String descripcion;

    private int stock;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Proveedor proveedor;

    @ManyToMany
    @JoinTable(name = "producto_categoria", joinColumns = @JoinColumn(name = "producto_id"),
    inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<>();
}
