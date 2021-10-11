package com.system.application.pizzaria.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Cliente extends User {

    private Integer idCliente;
    private List<Endereco> listaEnderecoCliente;
    private Pedido pedidoCliente;
}
