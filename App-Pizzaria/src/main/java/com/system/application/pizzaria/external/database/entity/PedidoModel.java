package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_PEDIDO")
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "STATUS", nullable = false, columnDefinition = "VARCHAR(25)")
    private String status;

    @Getter
    @Setter
    @Column(name = "PIZZA", nullable = true, columnDefinition = "VARCHAR(100)")
    private String pizza;

    @Getter
    @Setter
    @Column(name = "BEBIDA", nullable = true, columnDefinition = "VARCHAR(100)")
    private String bebida;

    @Getter
    @Setter
    @Column(name = "HORARIOPEDIDO", nullable = false, columnDefinition = "VARCHAR(9)")
    private String horarioPedido;

    @Getter
    @Setter
    @Column(name = "HORARIOESTIMADO", nullable = false, columnDefinition = "VARCHAR(9)")
    private String horarioEstimado;

    @Getter
    @Setter
    @Column(name = "PRECO", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal preco;

    @Getter
    @Setter
    @Column(name = "COMENTARIO", nullable = true, columnDefinition = "VARCHAR(300)")
    private String comentario;

}
