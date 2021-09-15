package com.system.application.pizzaria.entity;

import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Pizza {

    private Integer idPizza;
    private List<Ingrediente> listaIngredientesPizza;
    private CategoriaPizza categoriaPizza;
}
