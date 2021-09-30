package com.system.application.pizzaria.entity;

import com.system.application.pizzaria.external.database.entity.FuncionarioModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Cozinheiro extends FuncionarioModel {

    private Integer idCozinheiro;
    private List<Pedido> listaPizzaPedido;
    private List<Ingrediente> listaIngredientesPizza;

}
