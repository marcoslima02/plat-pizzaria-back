package com.system.application.pizzaria.external.database.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public abstract class UserModel {

    private String nome;
    private String cpf;
    private String apelido;
    private String senha;
    private String telefone;
}
