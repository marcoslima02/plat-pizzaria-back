package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table (name = "TB_INGREDIENTE")
@Getter
@Setter
public class IngredienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long idIngredienteModel;

    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nomeIngredienteModel;

    @Column(name = "QUANTIDADE", nullable = false, columnDefinition = "INTEGER")
    private Integer quantidadeIngredienteModel;

    @Column(name = "PRECO", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal precoIngredienteModel;

    @ManyToOne
    private PizzaModel pizzaModel;
}
