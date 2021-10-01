package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class User {

    private Integer idUser;
    private String nome;
    private String cpf;
    private String apelido;
    private String senha;
    private String telefone;

}