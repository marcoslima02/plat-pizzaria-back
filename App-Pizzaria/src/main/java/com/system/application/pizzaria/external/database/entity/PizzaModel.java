package com.system.application.pizzaria.external.database.entity;

import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
    private List<IngredienteModel> listaIngredientesPizzaModelPizzaModel;

    @Column(name = "CATEGORIA", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CategoriaPizza categoriaPizzaModel;

    @ManyToOne
    private PedidoModel pedidoModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PizzaModel that = (PizzaModel) o;
        return Objects.equals(idPizzaModel, that.idPizzaModel);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
