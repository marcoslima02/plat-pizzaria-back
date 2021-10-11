package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClienteVM extends UserVM{

    private Integer idClienteVM;
    private List<EnderecoVM> listaEnderecoVMClienteVM;
    private PedidoVM pedidoVMClienteVM;
}
