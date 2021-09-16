package com.system.application.pizzaria.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Atendente extends Funcionario{
    private Integer idAtendente;
    private List<Pedido> ListapedidoAtendente;
}
