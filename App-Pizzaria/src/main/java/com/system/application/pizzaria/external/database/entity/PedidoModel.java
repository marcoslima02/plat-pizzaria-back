package com.system.application.pizzaria.external.database.entity;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

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
    private Set<PizzaModel> pizzaPedidoModel;

    @Column(name = "BEBIDAS")
    @OneToMany(mappedBy = "pedidoModel")
    private Set<BebidaModel> bebidaPedidoModel;

    @ManyToOne
    private AtendenteModel atendenteModel;

    @Column(name = "HORARIO_PEDIDO", nullable = false, columnDefinition = "DATETIME")
    private String horarioPedidoModel;

    @Column(name = "HORARIO_ESTIMADO", nullable = false, columnDefinition = "DATETIME")
    private String horarioEstimadoPedidoModel;

    @Column(name = "PRECO", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal precoPedidoModel;

    @Column(name = "COMENTARIO", nullable = true, columnDefinition = "VARCHAR(300)")
    private String comentarioPedidoModel;

}
