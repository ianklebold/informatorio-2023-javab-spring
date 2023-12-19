package com.info.breakingmarket.controller.proveedor;

import com.info.breakingmarket.constants.ConstantsUtils;
import com.info.breakingmarket.dto.proveedor.ProveedorDto;
import com.info.breakingmarket.dto.respuesta.RespuestaDto;
import com.info.breakingmarket.service.proveedor.ProveedorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/proveedores", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ProveedorController {

    private final ProveedorService proveedorService;

    @PostMapping
    public ResponseEntity<RespuestaDto> crearProveedorConProductos(@Valid @RequestBody ProveedorDto proveedorDto){
        proveedorService.crearProveedorConProductos(proveedorDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new RespuestaDto(ConstantsUtils.STATUS_201,ConstantsUtils.MESSAGE_201));
    }

    @GetMapping("/{idProveedor}")
    public ResponseEntity<ProveedorDto> obtenerProveedorPorId(@PathVariable(name = "idProveedor")UUID idProveedor){
        ProveedorDto proveedorDto = proveedorService.obtenerProveedorPorId(idProveedor);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(proveedorDto);
    }

    @DeleteMapping("/{idProveedor}")
    public ResponseEntity<RespuestaDto> eliminarProveedor(@PathVariable(name = "idProveedor") UUID idProveedor){
        boolean fueEliminado = proveedorService.eliminarProveedorPorId(idProveedor);

        if (fueEliminado){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_200,ConstantsUtils.MESSAGE_200));
        }else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new RespuestaDto(ConstantsUtils.STATUS_500,ConstantsUtils.MESSAGE_500));
        }
    }


}
