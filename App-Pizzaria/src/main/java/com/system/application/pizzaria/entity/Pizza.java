package com.system.application.pizzaria.entity;

import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.external.database.entity.CozinheiroModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Pizza {

    private Integer idPizza;
    private BigDecimal precoPizza;
    private List<Ingrediente> listaIngredientesPizza;
    private CategoriaPizza categoriaPizza;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pizza that = (Pizza) o;
        return Objects.equals(idPizza, that.idPizza);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
