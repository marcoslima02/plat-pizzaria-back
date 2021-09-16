package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_ENDERECOS")
@Getter
@Setter
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CEP", nullable = false, columnDefinition = "VARCHAR(9)")
    private String cepEnderecoModel;

    @Column(name = "RUA", nullable = false, columnDefinition = "VARCHAR(100)")
    private String ruaEnderecoModel;

    @Column(name = "NUMERO", nullable = false, columnDefinition = "INTEGER")
    private Integer numeroEnderecoModel;

    @Column(name = "COMPLEMENTO", nullable = false, columnDefinition = "VARCHAR(100)")
    private String complementoEnderecoModel;

    @Column(name = "BAIRRO", nullable = false, columnDefinition = "VARCHAR(50)")
    private String bairroEnderecoModel;

    @Column(name = "CIDADE", nullable = false, columnDefinition = "VARCHAR(50)")
    private String cidade;

}
