package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IngredienteVM {

    private Integer idIngredienteVM;
    private String nomeIngredienteVM;
    private Integer quantidadeIngredienteVM;
    private BigDecimal precoIngredienteVM;
}
