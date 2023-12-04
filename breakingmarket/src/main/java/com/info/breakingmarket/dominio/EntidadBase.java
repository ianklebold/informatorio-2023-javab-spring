package com.info.breakingmarket.dominio;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@MappedSuperclass //Indicamos a JPA que esta clase actua como Super Class para todas las entidades que extiendan de esta.
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EntidadBase {
    private LocalDateTime creadoEn;
    private String creadoPor;
    private LocalDateTime actualizadoEn;
    private String actualizadoPor;

}
