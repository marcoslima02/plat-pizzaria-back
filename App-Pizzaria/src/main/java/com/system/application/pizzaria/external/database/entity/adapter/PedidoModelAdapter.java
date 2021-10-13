package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.database.entity.BebidaModel;
import com.system.application.pizzaria.external.database.entity.PedidoModel;
import com.system.application.pizzaria.external.database.entity.PizzaModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoModelAdapter {

    public static Pedido modelToEntity(PedidoModel pedidoModel) throws PedidoException {
        Pedido pedido = new Pedido();
        List<Pizza> pizzaList = new ArrayList<>();
        List<Bebida> bebidaList = new ArrayList<>();

        try {
            pedido.setIdPedido(pedidoModel.getIdPedidoModel());
            pedido.setStatusPedido(pedidoModel.getStatusPedidoModel());
            pedidoModel.getListaPizzaModelPedidoModel().forEach(pizzaModel -> {
                try {
                    pizzaList.add(PizzaModelAdapter.modelToEntity(pizzaModel));
                } catch (PizzaException e) {
                    e.printStackTrace();
                }
            });

            pedidoModel.getListaBebidaModelPedidoModel().forEach(bebidaModel -> {
                try {
                    bebidaList.add(BebidaModelAdapter.modelToEntity(bebidaModel));
                } catch (BebidaException e) {
                    e.printStackTrace();
                }
            });

            pedido.setHorarioPedido(pedidoModel.getHorarioPedidoModel());
            pedido.setHorarioEstimado(pedidoModel.getHorarioEstimadoPedidoModel());
            pedido.setPrecoPedido(pedidoModel.getPrecoPedidoModel());
            pedido.setComentarioPedido(pedidoModel.getComentarioPedidoModel());
            return pedido;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PedidoModel para Pedido");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter modelToEntity Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static PedidoModel entityToModel(Pedido pedido) throws PedidoException {
        PedidoModel pedidoModel = new PedidoModel();
        List<PizzaModel> pizzaModelList = new ArrayList<>();
        List<BebidaModel> bebidaModelList = new ArrayList<>();

        try {
            pedidoModel.setIdPedidoModel(pedido.getIdPedido());
            pedidoModel.setStatusPedidoModel(pedido.getStatusPedido());
            pedido.getListaPizzaPedido().forEach(pizza -> {
                try {
                    pizzaModelList.add(PizzaModelAdapter.entityToModel(pizza));
                } catch (PizzaException e) {
                    e.printStackTrace();
                }
            });
            pedido.getListaBebidaPedido().forEach(bebida -> {
                try {
                    bebidaModelList.add(BebidaModelAdapter.entityToModel(bebida));
                } catch (BebidaException e) {
                    e.printStackTrace();
                }
            });
            pedidoModel.setHorarioPedidoModel(pedido.getHorarioPedido());
            pedidoModel.setHorarioEstimadoPedidoModel(pedido.getHorarioEstimado());
            pedidoModel.setPrecoPedidoModel(pedido.getPrecoPedido());
            pedidoModel.setComentarioPedidoModel(pedido.getComentarioPedido());
            return pedidoModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pedido para PedidoModel");
            throw new PedidoException(ErrorType.VALIDATIONS, "Adapter entityToModel Pedido is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<PedidoModel> entityListToModelList(List<Pedido> pedidoList) {
        List<PedidoModel> pedidoModelList = new ArrayList<>();
        pedidoList.forEach(pedido -> {
            try {
                pedidoModelList.add(entityToModel(pedido));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
        return pedidoModelList;
    }

    public static List<Pedido> modelListToEntityList(List<PedidoModel> pedidoModelList) {
        List<Pedido> pedidoList = new ArrayList<>();
        pedidoModelList.forEach(pedidoModel -> {
            try {
                pedidoList.add(modelToEntity(pedidoModel));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
        return pedidoList;
    }

}
