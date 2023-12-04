package com.info.breakingmarket.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/producto",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ProductoController {

    @GetMapping
    public void sayHello(){
        System.out.println("Hola a todos");
    }


}
