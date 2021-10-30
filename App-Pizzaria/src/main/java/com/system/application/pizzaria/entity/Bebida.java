package com.system.application.pizzaria.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.PropertyValues;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
public class Bebida {

    private Integer idBebida;
    private String nomeBebida;
    private Integer quantidadeBebida;
    private BigDecimal precoBebida;
    private Integer identificacaoPedido;
    private Pedido pedidoEntidade;
    private List<Bebida> listaBebidas;
}
