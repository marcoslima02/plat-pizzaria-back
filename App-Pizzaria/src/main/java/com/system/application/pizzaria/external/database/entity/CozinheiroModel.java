package com.system.application.pizzaria.external.database.entity;


import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class CozinheiroModel extends FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idCozinheiroModel;

    @Column(name = "PIZZAS")
    @OneToMany(mappedBy = "cozinheiroModel")
    private List<PedidoModel> listaPedidoModelCozinheiroModel;

    @Column(name = "INGREDIENTES")
    @OneToMany(mappedBy = "cozinheiroModel")
    private List<IngredienteModel> listaIngredientesPizzaModelCozinheiroModel;
}