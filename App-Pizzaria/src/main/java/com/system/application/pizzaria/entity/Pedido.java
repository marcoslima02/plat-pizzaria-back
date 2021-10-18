package com.system.application.pizzaria.entity;

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
public class Pedido {

    private Integer idPedido;
    private StatusPedido statusPedido;
    private List<Pizza> listaPizzaPedido;
    private List<Bebida> listaBebidaPedido;
    private LocalDateTime horarioPedido;
    private LocalDateTime horarioEstimadoPedido;
    private BigDecimal precoPedido;
    private String comentarioPedido;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Pedido that = (Pedido) o;
        return Objects.equals(idPedido, that.idPedido);
    }

    @Override
    public int hashCode() {
        return 0;
    }

}
