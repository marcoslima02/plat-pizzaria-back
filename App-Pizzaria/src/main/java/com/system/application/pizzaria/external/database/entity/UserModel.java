package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@MappedSuperclass
public abstract class UserModel {

    @Column(name = "NOME", nullable = false, columnDefinition = "VARCHAR(100)")
    private String nome;
    @Column(name = "CPF", nullable = false, columnDefinition = "VARCHAR(14)")
    private String cpf;
    @Column(name = "APELIDO", columnDefinition = "VARCHAR(20)")
    private String apelido;
    @Column(name = "SENHA", nullable = false, columnDefinition = "VARCHAR(50)")
    private String senha;
    @Column(name = "TELEFONE", nullable = false, columnDefinition = "VARCHAR(25)")
    private String telefone;
}
