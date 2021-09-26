package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pedido;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CozinheiroVM {

    private Integer idCozinheiroVM;
    private List<Pedido> listaPizzaPedidoVM;
    private List<Ingrediente> listaIngredientesPizzaVM;


}
