package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class PizzaVM {

    private Integer idPizzaVM;
    private String nomePizzaVM;
    private BigDecimal precoPizzaVM;
    private Integer quantidadePizzaVM;
    private List<IngredienteVM> listaIngredientesPizzaVM;
    private CategoriaPizza categoriaPizzaVM;
}
