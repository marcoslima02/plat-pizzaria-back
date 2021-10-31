package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.*;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.*;
import com.system.application.pizzaria.external.database.entity.AdministradorModel;
import com.system.application.pizzaria.external.database.entity.CozinheiroModel;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.external.database.entity.PedidoModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdministradorModelAdapter {

    public static Administrador modelToEntity(AdministradorModel administradorModel) throws AdministradorException {
        Administrador administrador = new Administrador();
        List<Pagamento> pagamentoList = new ArrayList<>();

        try {
            administrador.setIdAdministrador(administradorModel.getIdAdministradorModel());
            administrador.setStatusPedidoAdministrador(administradorModel.getStatusPedidoModelAdministradorModel());

            administradorModel.getListaPagamentoModelAdministradorModel().forEach(pagamentoModel -> {
                try {
                    pagamentoList.add(PagamentoModelAdapter.modelToEntity(pagamentoModel));
                } catch (PagamentoException e) {
                    e.printStackTrace();
                }
            });

            return administrador;
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


