package com.system.application.pizzaria.entity;

import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.external.database.entity.CozinheiroModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class Pizza {

    private Integer idPizza;
    private String nomePizza;
    private BigDecimal precoPizza;
    private Integer quantidadePizza;
    private List<Ingrediente> listaIngredientesPizza;
    private CategoriaPizza categoriaPizza;
}
