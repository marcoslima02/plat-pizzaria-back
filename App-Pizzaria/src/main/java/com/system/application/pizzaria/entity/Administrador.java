package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Administrador extends Funcionario {
    private String statusPedido;
    private Pagamento pagamento;
}
