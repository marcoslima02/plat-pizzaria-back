package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PedidoVM {

    private Integer idPedidoVM;
    private StatusPedido statusPedidoVM;
    private List<PizzaVM> pizzaPedidoVM;
    private List<BebidaVM> listaBebidasPedidoVM;
    private LocalDateTime horarioPedidoVM;
    private LocalDateTime horarioEstimadoVM;
    private BigDecimal precoPedidoVM;
    private String comentarioPedidoVM;
}
