package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "TB_INGREDIENTE")
public class IngredienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nome;

    @Getter
    @Setter
    @Column(name = "QUANTIDADE", nullable = false, columnDefinition = "INTEGER")
    private Integer quantidade;

    @Getter
    @Setter
    @Column(name = "PRECO", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal preco;
}
