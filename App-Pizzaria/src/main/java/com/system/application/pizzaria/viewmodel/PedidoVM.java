package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
public class PedidoVM {

    private Integer id;

    @Setter
    private String status;

    @Setter
    private String pizza;

    @Setter
    private String bebida;

    @Setter
    private String horarioPedido;

    @Setter
    private String horarioEstimado;

    @Setter
    private BigDecimal preco;

    @Setter
    private String comentario;

}
