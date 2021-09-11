package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TB_BEBIBA")
public class BebidaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "NOME", nullable = false, columnDefinition = "STRING(100)")
    private String nome;

    @Getter
    @Setter
    @Column(name = "QUANTIDADE", nullable = false, columnDefinition = "INTEGER")
    private Integer quantidade;

    @Getter
    @Setter
    @Column(name = "PRECO", nullable = false, columnDefinition = "INTEGER")
    private BigDecimal preco;

}
