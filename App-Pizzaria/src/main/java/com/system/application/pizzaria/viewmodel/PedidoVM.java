package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class PedidoVM {

    private Integer idPedidoVM;
    private StatusPedido statusPedidoVM;
    private List<PizzaVM> listaPizzaVMPedidoVM;
    private List<BebidaVM> listaBebidaVMPedidoVM;
    private LocalDateTime horarioPedidoVM;
    private LocalDateTime horarioEstimadoPedidoVM;
    private BigDecimal precoPedidoVM;
    private String comentarioPedidoVM;
    private AtendenteVM nomeAtendenteVM;
    private CozinheiroVM nomeCozinheiroVM;
}
