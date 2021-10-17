package com.system.application.pizzaria.external.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "TB_BEBIDAS")
public class BebidaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idBebidaModel;

    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nomeBebidaModel;

    @Column(name = "QUANTIDADE", nullable = false, columnDefinition = "INTEGER")
    private Integer quantidadeBebidaModel;

    @Column(name = "PRECO", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal precoBebidaModel;

    @ManyToOne
    private PedidoModel pedidoModel;

}
