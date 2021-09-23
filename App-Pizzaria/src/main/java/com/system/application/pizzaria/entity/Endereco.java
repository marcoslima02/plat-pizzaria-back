package com.system.application.pizzaria.entity;

import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
public class Endereco {

    private Integer idEndereco;
    private String cepEndereco;
    private String ruaEndereco;
    private Integer numeroEndereco;
    private String complementoEndereco;
    private String bairroEndereco;
    private String cidadeEndereco;
}