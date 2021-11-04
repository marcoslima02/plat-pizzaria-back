package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class AdministradorVM extends FuncionarioVM {

    private Integer idAdministradorVM;
    private StatusPedido statusPedidoAdministrador;
    private List<PagamentoVM> listaPagamentoVMAdministradorVM;

}
