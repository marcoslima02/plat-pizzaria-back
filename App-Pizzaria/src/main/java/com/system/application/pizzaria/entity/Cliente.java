package com.system.application.pizzaria.entity;

import java.util.List;

public class Cliente extends User{

    private Integer idCliente;
    private List<Endereco> listaEnderecoCliente;
    private Pedido pedidoCliente;
}
