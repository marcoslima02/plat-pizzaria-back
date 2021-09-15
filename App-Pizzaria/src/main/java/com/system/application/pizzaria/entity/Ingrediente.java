package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Ingrediente {

    private Integer idIngrediente;
    private String nomeIngrediente;
    private Integer quantidadeIngrediente;
    private BigDecimal precoIngrediente;
}
