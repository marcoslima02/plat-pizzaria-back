package com.system.application.pizzaria.external.database.entity;

import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_PEDIDOS")
@Getter
@Setter
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idPedidoModel;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedidoModel = StatusPedido.AGUARDANDO;

    @Column(name = "PIZZAS")
    @OneToMany(mappedBy = "pedidoModel")
    private List<PizzaModel> listaPizzaModelPedidoModel;

    @Column(name = "BEBIDAS")
    @OneToMany(mappedBy = "pedidoModel")
    private List<BebidaModel> listaBebidaModelPedidoModel;

    @ManyToOne
    private AtendenteModel atendenteModel;

    @ManyToOne
    private CozinheiroModel cozinheiroModel;

    @Column(name = "HORARIO_PEDIDO", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime horarioPedidoModel;

    @Column(name = "HORARIO_ESTIMADO", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime horarioEstimadoPedidoModel;

    @Column(name = "PRECO", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal precoPedidoModel;

    @Column(name = "COMENTARIO", nullable = true, columnDefinition = "VARCHAR(300)")
    private String comentarioPedidoModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PedidoModel that = (PedidoModel) o;
        return Objects.equals(idPedidoModel, that.idPedidoModel);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
