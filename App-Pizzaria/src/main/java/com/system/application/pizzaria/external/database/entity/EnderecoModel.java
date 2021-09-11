package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_ENDERECO")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "CEP", nullable = false, columnDefinition = "VARCHAR(9)")
    private String cep;

    @Getter
    @Setter
    @Column(name = "RUA", nullable = false, columnDefinition = "VARCHAR(100)")
    private String rua;

    @Getter
    @Setter
    @Column(name = "NUMERO", nullable = false, columnDefinition = "INTEGER")
    private Integer numero;

    @Getter
    @Setter
    @Column(name = "COMPLEMENTO", nullable = false, columnDefinition = "VARCHAR(100)")
    private String complemento;

    @Getter
    @Setter
    @Column(name = "BAIRRO", nullable = false, columnDefinition = "VARCHAR(50)")
    private String bairro;

    @Getter
    @Setter@Column(name = "CIDADE", nullable = false, columnDefinition = "VARCHAR(50)")
    private String cidade;

}
