package com.system.application.pizzaria.usecase.endereco;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.external.EnderecoPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEnderecoById {

    @Autowired
    private EnderecoPersistenceDataBase enderecoPersistenceDataBase;

    public Endereco getEnderecoById(Integer idEndereco) throws EnderecoException {
        return enderecoPersistenceDataBase.getEnderecoById(idEndereco);
    }
}
