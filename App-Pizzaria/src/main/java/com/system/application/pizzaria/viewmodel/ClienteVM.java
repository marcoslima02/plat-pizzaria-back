package com.system.application.pizzaria.viewmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class ClienteVM extends UserVM{

    private Integer idClienteVM;
    private String emailClienteVM;
    private List<EnderecoVM> listaEnderecoVMClienteVM;
    private PedidoVM pedidoVMClienteVM;
}
