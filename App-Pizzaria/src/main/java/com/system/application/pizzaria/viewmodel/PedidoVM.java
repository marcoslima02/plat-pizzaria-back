package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.external.database.entity.PedidoModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class PedidoVM {

    private Integer idPedidoVM;
    private StatusPedido statusPedidoVM;
    private List<PizzaVM> listaPizzaVMPedidoVM;
    private List<BebidaVM> listaBebidaVMPedidoVM;
    private LocalDateTime horarioPedidoVM;
    private LocalDateTime horarioEstimadoPedidoVM;
    private BigDecimal precoPedidoVM;
    private String comentarioPedidoVM;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PedidoVM that = (PedidoVM) o;
        return Objects.equals(idPedidoVM, that.idPedidoVM);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
