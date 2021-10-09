package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.external.database.entity.AtendenteModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtendenteModelAdapter {

    public static Atendente modelToEntity(AtendenteModel atendenteModel) throws AtendenteException {
        List<Pedido> listaPedido = new ArrayList<>();
        Atendente atendenteEntity = new Atendente();

        try{
            atendenteEntity.setIdAtendente(atendenteModel.getIdAtendenteModel());
            atendenteEntity.setNome(atendenteModel.getNomeModel());
            atendenteEntity.setCpf(atendenteModel.getCpfModel());
            atendenteEntity.setApelido(atendenteModel.getApelidoModel());
            atendenteEntity.setSenha(atendenteModel.getSenhaModel());
            atendenteEntity.setTelefone(atendenteModel.getTelefoneModel());
            atendenteEntity.setHorarioTrabalho(atendenteModel.getHorarioTrabalhoModel());
            atendenteEntity.setSalario(atendenteModel.getSalarioModel());
            //TODO: colocar Pedido
            return atendenteEntity;

        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteModel para Atendente");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter modelToEntity Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static AtendenteModel entityToModel(Atendente atendenteEntity) throws AtendenteException {
        AtendenteModel atendenteModel = new AtendenteModel();

        try {
            atendenteModel.setIdAtendenteModel(atendenteEntity.getIdAtendente());
            atendenteModel.setNomeModel(atendenteEntity.getNome());
            atendenteModel.setCpfModel(atendenteEntity.getCpf());
            atendenteModel.setApelidoModel(atendenteEntity.getApelido());
            atendenteModel.setSenhaModel(atendenteEntity.getSenha());
            atendenteModel.setTelefoneModel(atendenteEntity.getTelefone());
            atendenteModel.setHorarioTrabalhoModel(atendenteEntity.getHorarioTrabalho());
            atendenteModel.setSalarioModel(atendenteEntity.getSalario());
            //TODO: colocar Pedido

            return atendenteModel;
        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de Atendente para AtendenteModel");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter entityToModel Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<AtendenteModel> entityListToModelList(List<Atendente> atendenteList){
        List<AtendenteModel> atendenteModelList = new ArrayList<>();
        atendenteList.forEach(atendente -> {
            try {
                atendenteModelList.add(entityToModel(atendente));
            } catch (AtendenteException e) {
                e.printStackTrace();
            }
        });
        return atendenteModelList;
    }

    public static List<Atendente> modelListToEntityList(List<AtendenteModel> atendenteModelList){
        List<Atendente> atendenteList = new ArrayList<>();
        atendenteModelList.forEach(atendenteModel -> {
            try {
                atendenteList.add(modelToEntity(atendenteModel));
            } catch (AtendenteException e) {
                e.printStackTrace();
            }
        });
        return atendenteList;
    }
}
