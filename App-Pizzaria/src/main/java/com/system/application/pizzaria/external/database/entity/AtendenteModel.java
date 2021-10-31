package com.system.application.pizzaria.external.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "TB_ATENDENTES")
public class AtendenteModel extends FuncionarioModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idAtendenteModel;

    @OneToMany(mappedBy = "atendenteModel")
    private List<PedidoModel> pedidoModel;
}
