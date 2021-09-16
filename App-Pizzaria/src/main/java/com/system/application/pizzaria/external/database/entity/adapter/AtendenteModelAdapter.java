package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorTypeApplication;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.external.database.entity.AtendenteModel;
import com.system.application.pizzaria.util.ConfigUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class AtendenteModelAdapter {

    public static Atendente modelToEntity(AtendenteModel atendenteModel) {
        List<Pedido> listaPedido = new ArrayList<>();
        Atendente atendenteEntity = new Atendente();

        try{
            atendenteEntity.setIdAtendente(atendenteModel.getIdAtendenteModel());
            atendenteEntity.setNome(atendenteModel.getNome());
            atendenteEntity.setCpf(atendenteModel.getCpf());
            atendenteEntity.setApelido(atendenteModel.getApelido());
            atendenteEntity.setSenha(atendenteModel.getSenha());
            atendenteEntity.setTelefone(atendenteModel.getTelefone());
            atendenteEntity.setHorarioTrabalho(atendenteModel.getHorarioTrabalho());
            atendenteEntity.setSalario(atendenteModel.getSalario());
            //TODO: colocar Pedido
            return atendenteEntity;

        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteModel para Atendente");
            throw new AtendenteException(AtendenteException.ErrorType.VALIDATIONS, "Adapter modelToEntity Atendente is Null");
        }
    }

    public static AtendenteModel entityToModel(Atendente atendenteEntity) {
        AtendenteModel atendenteModel = new AtendenteModel();

        try {
            atendenteModel.setIdAtendenteModel(atendenteEntity.getIdAtendente());
            atendenteModel.setNome(atendenteEntity.getNome());
            atendenteModel.setCpf(atendenteEntity.getCpf());
            atendenteModel.setApelido(atendenteEntity.getApelido());
            atendenteModel.setSenha(atendenteEntity.getSenha());
            atendenteModel.setTelefone(atendenteEntity.getTelefone());
            atendenteModel.setHorarioTrabalho(atendenteEntity.getHorarioTrabalho());
            atendenteModel.setSalario(atendenteEntity.getSalario());
            //TODO: colocar Pedido

            return atendenteModel;
        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de Atendente para AtendenteModel");
            throw new AtendenteException(AtendenteException.ErrorType.VALIDATIONS, "Adapter entityToModel Atendente is Null");
        }
    }
}
