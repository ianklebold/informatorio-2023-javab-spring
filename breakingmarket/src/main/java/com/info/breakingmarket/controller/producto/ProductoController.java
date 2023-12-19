package com.info.breakingmarket.controller.producto;

import com.info.breakingmarket.constants.ConstantsUtils;
import com.info.breakingmarket.dominio.Producto;
import com.info.breakingmarket.dto.producto.ProductoDto;
import com.info.breakingmarket.dto.respuesta.RespuestaDto;
import com.info.breakingmarket.service.producto.ProductoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/productos", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ProductoController {

    private final ProductoService productoService;

    @PutMapping("/{idProducto}")
    public ResponseEntity<RespuestaDto> actualizarProducto(@PathVariable(name = "idProducto") UUID idProducto,
            @Valid @RequestBody ProductoDto productoDto){

        boolean fueActualizado = productoService.actualizarProducto(idProducto,productoDto);

        if (fueActualizado){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_200,ConstantsUtils.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_500,ConstantsUtils.MESSAGE_500));
        }

    }

    @GetMapping()
    public List<ProductoDto> obtenerTodosLosProductos(
            @RequestParam(name = "nombre",required = false) String nombre,
            @Pattern(regexp = "(^$|[0-9]*)") @RequestParam(name = "stock", defaultValue = "0") String stock
    ){
        return productoService.obtenerTodosLosProductos(nombre,stock);
    }


}
