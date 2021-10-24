package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public class PedidoCadastroVM {
    private Integer idPedidoCadastroVM;
    private StatusPedido statusPedidoCadastroVM;
    private LocalDateTime horarioPedidoCadastroVM;
    private LocalDateTime horarioEstimadoPedidoCadastroVM;
    private BigDecimal precoPedidoCadastroVM;
    private String comentarioPedidoCadastroVM;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PedidoCadastroVM that = (PedidoCadastroVM) o;
        return Objects.equals(idPedidoCadastroVM, that.idPedidoCadastroVM);
    }

    @Override
    public int hashCode() {
        return 0;
    }


}
