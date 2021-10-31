package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class AdministradorVM extends FuncionarioVM {

    private Integer idAdminitradorVM;
    private StatusPedido statusPedidoAdministrador;
    private Pagamento pagamentoAdministradorVM;

}
