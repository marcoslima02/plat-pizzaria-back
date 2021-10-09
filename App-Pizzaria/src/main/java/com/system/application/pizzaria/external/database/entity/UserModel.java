package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TB_USER")
public abstract class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer idUserModel;

    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nomeModel;

    @Column(name = "CPF", nullable = false, columnDefinition = "VARCHAR(14)")
    private String cpfModel;

    @Column(name = "APELIDO", columnDefinition = "VARCHAR(20)")
    private String apelidoModel;

    @Column(name = "SENHA", nullable = false, columnDefinition = "VARCHAR(50)")
    private String senhaModel;

    @Column(name = "TELEFONE", nullable = false, columnDefinition = "VARCHAR(25)")
    private String telefoneModel;

}
