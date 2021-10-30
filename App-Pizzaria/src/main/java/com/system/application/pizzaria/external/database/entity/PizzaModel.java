package com.system.application.pizzaria.external.database.entity;

import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_PIZZA")
@EqualsAndHashCode

public class PizzaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idPizzaModel;

    @Column(name = "NOME_PIZZA", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nomePizzaModel;

    @Column(name = "PRECO_PIZZA", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal precoPizzaModel;

    @Column(name = "QUANTIDADE_PIZZA", nullable = false, columnDefinition = "INTEGER")
    private Integer quantidadePizzaModel;

    @Column(name = "INGREDIENTES")
    @OneToMany(mappedBy = "pizzaModel")
    private List<IngredienteModel> listaIngredientesPizzaModel;

    @Column(name = "CATEGORIA", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CategoriaPizza categoriaPizzaModel;

    @ManyToOne
    private PedidoModel pedidoModel;
}
