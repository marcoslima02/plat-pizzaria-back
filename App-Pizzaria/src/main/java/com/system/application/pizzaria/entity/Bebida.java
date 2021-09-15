package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class Bebida {

    private Integer idBebida;
    private String nomeBebida;
    private Integer quantidadeBebida;
    private BigDecimal precoBebida;

}
