package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class User {

    private Integer id;

    @Setter
    private String nome;

    @Setter
    private String cpf;

    @Setter
    private String apelido;

    @Setter
    private String senha;

    @Setter
    private String telefone;
}