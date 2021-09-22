package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.util.ConfigUtils;

public class EnderecoModelAdapter {

    public static Endereco modelToEntity(EnderecoModel enderecoModel) {
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
            throw new EnderecoException(EnderecoException.ErrorType.VALIDATIONS, "Adapter modelToEntity Endereco is Null");
        }
    }

    public static EnderecoModel entityToModel(Endereco endereco) {
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
        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de Endereco para EnderecoModel");
            throw new EnderecoException(EnderecoException.ErrorType.VALIDATIONS, "Adapter entityToModel Endereco is Null");
        }
    }
}
