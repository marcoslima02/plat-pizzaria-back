package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UserVM {

    private String nome;
    private String cpf;
    private String apelido;
    private String senha;
    private String telefone;
}
