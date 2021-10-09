package com.system.application.pizzaria.external.database.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

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
    private Set<PedidoModel> listaPizzaPedidoModel;

    @Column(name = "INGREDIENTES")
    @OneToMany(mappedBy = "cozinheiroModel")
    private Set<IngredienteModel> listaIngredientesPizzaModel;

}