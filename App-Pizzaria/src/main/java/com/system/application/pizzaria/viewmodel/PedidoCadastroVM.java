package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PedidoCadastroVM {
    private Integer idPedidoCadastroVM;
    private StatusPedido statusPedidoCadastroVM;
    private LocalDateTime horarioPedidoCadastroVM;
    private LocalDateTime horarioEstimadoPedidoCadastroVM;
    private BigDecimal precoPedidoCadastroVM;
    private String comentarioPedidoCadastroVM;


}
