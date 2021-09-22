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

    public Endereco(EnderecoModel enderecoModel){
        this.idEndereco = enderecoModel.getIdEndereco();
        this.cepEndereco = enderecoModel.getCepEnderecoModel();
        this.ruaEndereco = enderecoModel.getRuaEnderecoModel();
        this.numeroEndereco = enderecoModel.getNumeroEnderecoModel();
        this.complementoEndereco = enderecoModel.getComplementoEnderecoModel();
        this.bairroEndereco = enderecoModel.getBairroEnderecoModel();
        this.cidadeEndereco = enderecoModel.getCidadeEnderecoModel();
    }
    public Endereco(){}

    public static List<Endereco> converter(List<EnderecoModel> enderecoModels){
        return enderecoModels.stream().map(Endereco::new).collect(Collectors.toList());
    }
}