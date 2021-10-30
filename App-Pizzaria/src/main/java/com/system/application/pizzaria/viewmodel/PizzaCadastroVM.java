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
public class PizzaCadastroVM {

    private String nomePizzaCadastroVM;
    private BigDecimal precoPizzaCadastroVM;
    private Integer quantidadePizzaCadastroVM;
    private List<IngredienteVM> listaIngredientesPizzaCadastroVM;
    private CategoriaPizza categoriaPizzaCadastroVM;

}
