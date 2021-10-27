package com.system.application.pizzaria.viewmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class PedidoCadastroVM {

    private List<PizzaVM> pizzaVMList;
    private List<BebidaVM> bebidaVMList;
    private BigDecimal precoTotalPedido;
    private String comentarioPedidoCadastroVM;

}
