package com.system.application.pizzaria.external.database;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.external.GetAllEnderecoByIdDataBase;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.external.database.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllEnderecoByIdDataBaseImpl implements GetAllEnderecoByIdDataBase {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> executeAllEnderecos() {
        List<EnderecoModel> enderecoModelList = enderecoRepository.findAll();
        return Endereco.converter(enderecoModelList);
    }
}
