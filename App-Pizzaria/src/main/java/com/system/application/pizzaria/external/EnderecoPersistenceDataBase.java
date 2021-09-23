package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.exception.EnderecoException;

import java.util.List;

public interface EnderecoPersistenceDataBase {
    List<Endereco> getAllEnderecos();
    Endereco getEnderecoById(Integer idEndereco) throws EnderecoException;
}
