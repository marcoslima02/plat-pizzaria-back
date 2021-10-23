package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class PizzaVM {

    private Integer idPizzaVM;
    private BigDecimal precoPizzaVM;
    private List<IngredienteVM> listaIngredientesPizzaVM;
    private CategoriaPizza categoriaPizzaVM;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PizzaVM that = (PizzaVM) o;
        return Objects.equals(idPizzaVM, that.idPizzaVM);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
