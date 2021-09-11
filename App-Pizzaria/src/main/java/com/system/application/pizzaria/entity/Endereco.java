package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class Endereco {

    private Integer id;

    @Setter
    private String cep;

    @Setter
    private String rua;

    @Setter
    private Integer numero;

    @Setter
    private String complemento;

    @Setter
    private String bairro;

    @Setter
    private String cidade;

}