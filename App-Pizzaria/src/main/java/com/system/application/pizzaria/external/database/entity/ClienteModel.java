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
@Table(name = "TB_CLIENTES")
public class ClienteModel extends UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idClienteModel;

    @Column(name = "ENDERECO_CLIENTE")
    @OneToMany(mappedBy = "clienteModelEnderecoModel")
    private List<EnderecoModel> listaEnderecoModelClienteModel;

    @OneToOne
    private PedidoModel pedidoModelClienteModel;

}
