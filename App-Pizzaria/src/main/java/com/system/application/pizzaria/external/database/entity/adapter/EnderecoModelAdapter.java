package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnderecoModelAdapter {

    public static Endereco modelToEntity(EnderecoModel enderecoModel) throws EnderecoException {
        Endereco endereco = new Endereco();
        try {
            endereco.setIdEndereco(enderecoModel.getIdEndereco());
            endereco.setCepEndereco(enderecoModel.getCepEnderecoModel());
            endereco.setRuaEndereco(enderecoModel.getRuaEnderecoModel());
            endereco.setCidadeEndereco(enderecoModel.getCidadeEnderecoModel());
            endereco.setNumeroEndereco(enderecoModel.getNumeroEnderecoModel());
            endereco.setBairroEndereco(enderecoModel.getBairroEnderecoModel());
            endereco.setComplementoEndereco(enderecoModel.getComplementoEnderecoModel());
            return endereco;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de EnderecoModel para Endereco");
            throw new EnderecoException(ErrorType.VALIDATIONS, "Adapter modelToEntity Endereco is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static EnderecoModel entityToModel(Endereco endereco) throws EnderecoException {
        try {
            EnderecoModel enderecoModel = new EnderecoModel();
            enderecoModel.setIdEndereco(endereco.getIdEndereco());
            enderecoModel.setCepEnderecoModel(endereco.getCepEndereco());
            enderecoModel.setRuaEnderecoModel(endereco.getRuaEndereco());
            enderecoModel.setCidadeEnderecoModel(endereco.getCidadeEndereco());
            enderecoModel.setNumeroEnderecoModel(endereco.getNumeroEndereco());
            enderecoModel.setBairroEnderecoModel(endereco.getBairroEndereco());
            enderecoModel.setComplementoEnderecoModel(endereco.getComplementoEndereco());
            return enderecoModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Endereco para EnderecoModel");
            throw new EnderecoException(ErrorType.VALIDATIONS, "Adapter entityToModel Endereco is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<EnderecoModel> entityListToModelList(List<Endereco> enderecoList) {
        List<EnderecoModel> enderecoModelList = new ArrayList<>();
        enderecoList.forEach(endereco -> {
            try {
                enderecoModelList.add(entityToModel(endereco));
            } catch (EnderecoException e) {
                e.printStackTrace();
            }
        });
        return enderecoModelList;
    }

    public static List<Endereco> modelListToEntityList(List<EnderecoModel> enderecoModelList) {
        List<Endereco> enderecoList = new ArrayList<>();
        enderecoModelList.forEach(enderecoModel -> {
            try {
                enderecoList.add(modelToEntity(enderecoModel));
            } catch (EnderecoException e) {
                e.printStackTrace();
            }
        });
        return enderecoList;
    }
}
