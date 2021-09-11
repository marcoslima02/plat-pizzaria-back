package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class Ingrediente {

    private Integer id;

    @Setter
    private String nome;

    @Setter
    private Integer quantidade;

    @Setter
    private BigDecimal preco;


}
