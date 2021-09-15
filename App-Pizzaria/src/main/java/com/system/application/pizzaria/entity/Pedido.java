package com.system.application.pizzaria.entity;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Pedido {

    private Integer idPedido;
    private StatusPedido statusPedido;
    private List<Pizza> pizza;
    private List<Bebida> listaBebidasPedido;
    private LocalDateTime horarioPedido;
    private LocalDateTime horarioEstimado;
    private BigDecimal precoPedido;
    private String comentarioPedido;
}
