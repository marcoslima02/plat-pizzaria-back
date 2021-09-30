package com.system.application.pizzaria.external.database.entity;


import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TB_PIZZA")
public class PizzaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idPizzaModel;

    @Column(name = "PRECO_PIZZA", nullable = false, columnDefinition = "DOUBLE")
    private BigDecimal precoPizzaModel;

    @Column(name = "INGREDIENTES")
    @OneToMany(mappedBy = "pizzaModel")
    private Set<IngredienteModel> listaIngredientesPizzaModel;

    @Column(name = "CATEGORIA", nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaPizza categoriaPizzaModel;

    @ManyToOne
    private PedidoModel pedidoModel;
}
