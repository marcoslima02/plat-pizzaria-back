package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PizzaVM {

    private Integer idPizzaVM;
    private BigDecimal precoPizzaVM;
    private List<IngredienteVM> listaIngredientesPizzaVM;
    private CategoriaPizza categoriaPizzaVM;
}
