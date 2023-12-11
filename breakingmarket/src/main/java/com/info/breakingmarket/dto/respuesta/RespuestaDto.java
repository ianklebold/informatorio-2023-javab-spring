package com.info.breakingmarket.dto.respuesta;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespuestaDto {
    private String statusCode;
    private String statusMsg;
}
