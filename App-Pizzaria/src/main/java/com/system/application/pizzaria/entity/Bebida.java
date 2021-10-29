package com.system.application.pizzaria.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
public class Bebida {

    private Integer idBebida;
    private String nomeBebida;
    private List<Bebida> listaBebida;
    private Integer quantidadeBebida;
    private BigDecimal precoBebida;

}
