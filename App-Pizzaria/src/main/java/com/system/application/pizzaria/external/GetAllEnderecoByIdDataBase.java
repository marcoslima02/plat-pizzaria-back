package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Endereco;

import java.util.List;

public interface GetAllEnderecoByIdDataBase {
    List<Endereco> executeAllEnderecos();
}
