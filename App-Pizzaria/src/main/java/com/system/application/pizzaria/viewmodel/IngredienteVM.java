package com.system.application.pizzaria.viewmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class IngredienteVM {

    private Integer idIngredienteVM;
    private String nomeIngredienteVM;
    private Integer quantidadeIngredienteVM;
    private BigDecimal precoIngredienteVM;
}
