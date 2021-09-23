package com.system.application.pizzaria.external.database.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "TB_ENDERECOS")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idEndereco;

    @Column(name = "CEP", columnDefinition = "VARCHAR(9)")
    private String cepEnderecoModel;

    @Column(name = "RUA", columnDefinition = "VARCHAR(100)")
    private String ruaEnderecoModel;

    @Column(name = "NUMERO", columnDefinition = "INTEGER")
    private Integer numeroEnderecoModel;

    @Column(name = "COMPLEMENTO", columnDefinition = "VARCHAR(100)")
    private String complementoEnderecoModel;

    @Column(name = "BAIRRO", columnDefinition = "VARCHAR(50)")
    private String bairroEnderecoModel;

    @Column(name = "CIDADE", columnDefinition = "VARCHAR(50)")
    private String cidadeEnderecoModel;

}
