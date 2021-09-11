package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class IngredienteVM {

    private Integer id;

    @Setter
    private String nome;

    @Setter
    private Integer quantidade;

    @Setter
    private BigDecimal preco;
}
