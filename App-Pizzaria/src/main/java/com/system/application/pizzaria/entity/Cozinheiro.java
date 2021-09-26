package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cozinheiro {

    private Integer idCozinheiro;
    private List<Pedido> listaPizzaPedido;
    private List<Ingrediente> listaIngredientesPizza;

}
