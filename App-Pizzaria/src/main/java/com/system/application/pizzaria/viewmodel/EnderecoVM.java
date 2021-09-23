package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
public class EnderecoVM {

    private Integer idEnderecoVM;
    private String cepEnderecoVM;
    private String ruaEnderecoVM;
    private Integer numeroEnderecoVM;
    private String complementoEnderecoVM;
    private String bairroEnderecoVM;
    private String cidadeEnderecoVM;
}
