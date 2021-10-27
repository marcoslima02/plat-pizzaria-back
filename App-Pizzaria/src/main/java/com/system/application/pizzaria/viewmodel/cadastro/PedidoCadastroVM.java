package com.system.application.pizzaria.viewmodel.cadastro;

import com.system.application.pizzaria.viewmodel.AtendenteVM;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.CozinheiroVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
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
    private AtendenteVM atendenteResponsavelVM;
    private CozinheiroVM cozinheiroResponsavelVM;
}
