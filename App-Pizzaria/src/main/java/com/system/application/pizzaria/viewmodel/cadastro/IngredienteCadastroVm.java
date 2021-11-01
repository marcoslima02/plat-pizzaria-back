package com.system.application.pizzaria.viewmodel.cadastro;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode

public class IngredienteCadastroVm {
    private String nomeIngredienteVM;
    private Integer quantidadeIngredienteVM;
    private BigDecimal precoIngredienteVM;

}