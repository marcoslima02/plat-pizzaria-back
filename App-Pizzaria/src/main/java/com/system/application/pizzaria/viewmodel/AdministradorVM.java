package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.Pagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministradorVM extends FuncionarioVM {
    private String statusPedidoVM;
    private Pagamento pagamentoVM;
}
