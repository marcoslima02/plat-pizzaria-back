package com.system.application.pizzaria.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class Ingrediente {

    private Integer idIngrediente;
    private String nomeIngrediente;
    private Integer quantidadeIngrediente;
    private BigDecimal precoIngrediente;
}
