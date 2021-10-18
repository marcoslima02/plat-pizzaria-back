package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.*;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.*;
import com.system.application.pizzaria.external.database.entity.*;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CozinheiroModelAdapter {

    public static Cozinheiro modelToEntity(CozinheiroModel cozinheiroModel) throws CozinheiroException {
        Cozinheiro cozinheiro = new Cozinheiro();
        List<Pedido> pedidoList = new ArrayList<>();
        List<Ingrediente> ingredienteList = new ArrayList<>();

        try {
            cozinheiro.setIdCozinheiro(cozinheiroModel.getIdCozinheiroModel());
            cozinheiroModel.getListaPizzaPedidoModelCozinheiroModel().forEach(pedidoModel -> {
                try {
                    pedidoList.add(PedidoModelAdapter.modelToEntity(pedidoModel));
                } catch (PedidoException e) {
                    e.printStackTrace();
                }
            });

            cozinheiroModel.getListaIngredientesPizzaModelCozinheiroModel().forEach(ingredienteModel -> {
                try {
                    ingredienteList.add(IngredienteModelAdapter.modelToEntity(ingredienteModel));
                } catch (IngredienteException e) {
                    e.printStackTrace();
                }
            });

            return cozinheiro;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de CozinheiroModel para Cozinheiro");
            throw new CozinheiroException(ErrorType.VALIDATIONS, "Adapter modelToEntity Cozinheiro is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static CozinheiroModel entityToModel(Cozinheiro cozinheiro) throws CozinheiroException {
        CozinheiroModel cozinheiroModel = new CozinheiroModel();
        List<PedidoModel> pedidoModelList = new ArrayList<>();
        List<IngredienteModel> ingredienteModelList = new ArrayList<>();

        try {
            cozinheiroModel.setIdCozinheiroModel(cozinheiro.getIdCozinheiro());
            cozinheiro.getListaPizzaPedidoCozinheiro().forEach(pedido -> {
                try {
                    pedidoModelList.add(PedidoModelAdapter.entityToModel(pedido));
                } catch (PedidoException e) {
                    e.printStackTrace();
                }
            });
            cozinheiro.getListaIngredientesPizzaCozinheiro().forEach(ingrediente -> {
                try {
                    ingredienteModelList.add(IngredienteModelAdapter.entityToModel(ingrediente));
                } catch (IngredienteException e) {
                    e.printStackTrace();
                }
            });
            return cozinheiroModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Cozinheiro para CozinheiroModel");
            throw new CozinheiroException(ErrorType.VALIDATIONS, "Adapter entityToModel Cozinheiro is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<CozinheiroModel> entityListToModelList(List<Cozinheiro> cozinheiroList) {
        List<CozinheiroModel> cozinheiroModelList = new ArrayList<>();
        cozinheiroList.forEach(cozinheiro -> {
            try {
                cozinheiroModelList.add(entityToModel(cozinheiro));
            } catch (CozinheiroException e) {
                e.printStackTrace();
            }
        });
        return cozinheiroModelList;
    }

    public static List<Cozinheiro> modelListToEntityList(List<CozinheiroModel> cozinheiroModelList) {
        List<Cozinheiro> cozinheiroList = new ArrayList<>();
        cozinheiroModelList.forEach(cozinheiroModel -> {
            try {
                cozinheiroList.add(modelToEntity(cozinheiroModel));
            } catch (CozinheiroException e) {
                e.printStackTrace();
            }
        });
        return cozinheiroList;
    }

}
