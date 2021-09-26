package com.system.application.pizzaria.external.database.entity;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pedido;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_COZINHEIRO")
public class CozinheiroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idCozinheiroModel;

    @Column(name = "PIZZAS")
    @OneToMany(mappedBy = "cozinheiroModel")
    private set<PedidoModel> listaPizzaPedidoModel;

    @Column(name = "INGREDIENTES")
    @OneToMany(mappedBy = "cozinheiroModel")
    private set<IngredienteModel> listaIngredientesPizzaModel;

}
