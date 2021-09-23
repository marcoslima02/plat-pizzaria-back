package com.system.application.pizzaria.usecase.endereco;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.external.EnderecoPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEndereco {

    @Autowired
    private EnderecoPersistenceDataBase enderecoPersistenceDataBase;

    public List<Endereco> getAllEnderecos(){
        return enderecoPersistenceDataBase.getAllEnderecos();
    }
}
