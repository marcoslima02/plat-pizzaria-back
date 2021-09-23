package com.system.application.pizzaria.external.database;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.external.EnderecoPersistenceDataBase;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.external.database.entity.adapter.EnderecoModelAdapter;
import com.system.application.pizzaria.external.database.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class EnderecoPersistenceDataBaseImpl implements EnderecoPersistenceDataBase {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<Endereco> getAllEnderecos() {
        List<EnderecoModel> enderecoModelList = enderecoRepository.findAll();
        return EnderecoModelAdapter.modelListToEntityList(enderecoModelList);
    }

    @Override
    public Endereco getEnderecoById(Integer idEndereco) throws EnderecoException {
        try {
            EnderecoModel enderecoModel = enderecoRepository.getById(idEndereco);
            return EnderecoModelAdapter.modelToEntity(enderecoModel);
        } catch (Exception e) {
            throw new EnderecoException(ErrorType.DATA_BASE_NOT_FOUND, String.format("DATABASE endereco NOT FOUND FOR ID: %d", idEndereco), new Date(), HttpStatus.NOT_FOUND);
        }
    }
}
