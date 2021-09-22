package com.system.application.pizzaria.usecase;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.external.GetAllEnderecoByIdDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllEndereco {

    @Autowired
    private GetAllEnderecoByIdDataBase getAllEnderecoByIdDataBase;

    public List<Endereco> execute(){
        return getAllEnderecoByIdDataBase.executeAllEnderecos();
    }
}
