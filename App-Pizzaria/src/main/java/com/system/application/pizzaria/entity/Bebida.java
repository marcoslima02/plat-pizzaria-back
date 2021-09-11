package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
public abstract class Bebida {

    private Integer id;

    @Setter
    private String nome;

    @Setter
    private Integer quantidade;

    @Setter
    private BigDecimal preco;

}
