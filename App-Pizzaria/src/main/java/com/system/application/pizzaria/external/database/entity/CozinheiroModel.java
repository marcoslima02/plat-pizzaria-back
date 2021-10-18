package com.system.application.pizzaria.external.database.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "TB_COZINHEIRO")
public class CozinheiroModel extends FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idCozinheiroModel;

    @Column(name = "PIZZAS")
    @OneToMany(mappedBy = "cozinheiroModel")
    private List<PedidoModel> listaPizzaPedidoModelCozinheiroModel;

    @Column(name = "INGREDIENTES")
    @OneToMany(mappedBy = "cozinheiroModel")
    private List<IngredienteModel> listaIngredientesPizzaModelCozinheiroModel;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CozinheiroModel that = (CozinheiroModel) o;
        return Objects.equals(idCozinheiroModel, that.idCozinheiroModel);
    }

    @Override
    public int hashCode() {
        return 0;
    }

}