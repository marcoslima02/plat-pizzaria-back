package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TB_USERS")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nome;

    @Getter
    @Setter
    @Column(name = "CPF", nullable = false, columnDefinition = "VARCHAR(14)")
    private String cpf;

    @Getter
    @Setter
    @Column(name = "APELIDO", columnDefinition = "VARCHAR(20)")
    private String apelido;

    @Getter
    @Setter
    @Column(name = "SENHA", nullable = false, columnDefinition = "VARCHAR(50)")
    private String senha;

    @Getter
    @Setter
    @Column(name = "TELEFONE", nullable = false, columnDefinition = "VARCHAR(25)")
    private String telefone;
}
