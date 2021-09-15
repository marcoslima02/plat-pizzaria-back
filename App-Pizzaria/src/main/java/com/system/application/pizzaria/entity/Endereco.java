package com.system.application.pizzaria.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    private Integer idEndereco;
    private String cepEndereco;
    private String ruaEndereco;
    private Integer numeroEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;

}