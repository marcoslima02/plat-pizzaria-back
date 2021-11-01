package com.system.application.pizzaria.entity;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Administrador extends Funcionario {

    private Integer idAdministrador;
    private StatusPedido statusPedidoAdministrador;
    private List<Pagamento> listaPagamentoAdministrador;

}
