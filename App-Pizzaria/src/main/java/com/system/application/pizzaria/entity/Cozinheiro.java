package com.system.application.pizzaria.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class Cozinheiro extends Funcionario {

    private Integer idCozinheiro;
    private List<Pedido> listaPedidoCozinheiro;
    private List<Ingrediente> listaIngredientesPizzaCozinheiro;
}
