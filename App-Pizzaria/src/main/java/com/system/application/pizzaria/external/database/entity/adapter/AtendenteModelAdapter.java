package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.external.database.entity.AtendenteModel;
import com.system.application.pizzaria.external.database.entity.PedidoModel;
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
            validaListaPedidoIsNull(atendenteModel, listaPedido, atendenteEntity);
            return atendenteEntity;

        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteModel para Atendente");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter modelToEntity Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Atendente modelToEntityAtendenteInfo(AtendenteModel atendenteModel) throws AtendenteException {
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
            return atendenteEntity;

        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteModel para Atendente");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter modelToEntity Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validaListaPedidoIsNull(AtendenteModel atendenteModel, List<Pedido> listaPedido, Atendente atendenteEntity) {
        if(atendenteModel.getPedidoModel() != null){
            percorreListaPedidoModel(atendenteModel, listaPedido);
            atendenteEntity.setListapedidoAtendente(listaPedido);
        }
    }

    private static void percorreListaPedidoModel(AtendenteModel atendenteModel, List<Pedido> listaPedido) {
        atendenteModel.getPedidoModel().forEach(pedidoModel -> {
            try {
                listaPedido.add(PedidoModelAdapter.modelToEntity(pedidoModel));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
    }

    public static AtendenteModel entityToModel(Atendente atendenteEntity) throws AtendenteException {
        AtendenteModel atendenteModel = new AtendenteModel();
        List<PedidoModel> pedidoModelList = new ArrayList<>();
        try {
            atendenteModel.setIdAtendenteModel(atendenteEntity.getIdAtendente());
            atendenteModel.setNomeModel(atendenteEntity.getNome());
            atendenteModel.setCpfModel(atendenteEntity.getCpf());
            atendenteModel.setApelidoModel(atendenteEntity.getApelido());
            atendenteModel.setSenhaModel(atendenteEntity.getSenha());
            atendenteModel.setTelefoneModel(atendenteEntity.getTelefone());
            atendenteModel.setHorarioTrabalhoModel(atendenteEntity.getHorarioTrabalho());
            atendenteModel.setSalarioModel(atendenteEntity.getSalario());
            validaListaPedidoIsNull(atendenteEntity, pedidoModelList);
            return atendenteModel;
        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de Atendente para AtendenteModel");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter entityToModel Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validaListaPedidoIsNull(Atendente atendenteEntity, List<PedidoModel> pedidoModelList) {
        if(atendenteEntity.getListapedidoAtendente() != null){
            percorreListaPedidoEntity(atendenteEntity, pedidoModelList);
        }
    }

    private static void percorreListaPedidoEntity(Atendente atendenteEntity, List<PedidoModel> pedidoModelList) {
        atendenteEntity.getListapedidoAtendente().forEach(pedido -> {
            try {
                pedidoModelList.add(PedidoModelAdapter.entityToModel(pedido));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
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
