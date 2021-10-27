package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class Cozinheiro extends Funcionario {

    private Integer idCozinheiro;
    private List<Pedido> listaPizzaPedidoCozinheiro;
    private List<Ingrediente> listaIngredientesPizzaCozinheiro;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Cozinheiro that = (Cozinheiro) o;
        return Objects.equals(idCozinheiro, that.idCozinheiro);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
