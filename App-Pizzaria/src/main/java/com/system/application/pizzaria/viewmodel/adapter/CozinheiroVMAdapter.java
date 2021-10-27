package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.*;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.*;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CozinheiroVMAdapter {

    public static Cozinheiro viewModelToEntity(CozinheiroVM cozinheiroVM) throws CozinheiroException {
        Cozinheiro cozinheiro = new Cozinheiro();
        List<Pedido> pedidoList = new ArrayList<>();
        List<Ingrediente> ingredienteList = new ArrayList<>();

        try {
            cozinheiro.setIdCozinheiro(cozinheiroVM.getIdCozinheiroVM());
            cozinheiroVM.getListaPizzaPedidoVMCozinheiroVM().forEach(pedidoVM -> {
                try {
                    pedidoList.add(PedidoVMAdapter.viewModelToEntity(pedidoVM));
                } catch (PedidoException e) {
                    e.printStackTrace();
                }
            });
            cozinheiroVM.getListaIngredientesPizzaVMCozinheiroVM().forEach(ingredienteVM -> {
                try {
                    ingredienteList.add(IngredienteVMAdapter.viewModelToEntity(ingredienteVM));
                } catch (IngredienteException e) {
                    e.printStackTrace();
                }
            });
            return cozinheiro;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de CozinheiroModel para Cozinheiro");
            throw new CozinheiroException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Cozinheiro is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static CozinheiroVM entityToViewModel(Cozinheiro cozinheiro) throws CozinheiroException {
        CozinheiroVM cozinheiroVM = new CozinheiroVM();
        List<PedidoVM> pedidoVMList = new ArrayList<>();
        List<IngredienteVM> ingredienteVMList = new ArrayList<>();

        try {
            cozinheiroVM.setIdCozinheiroVM(cozinheiro.getIdCozinheiro());
            cozinheiro.getListaPizzaPedidoCozinheiro().forEach(pedido -> {
                try {
                    pedidoVMList.add(PedidoVMAdapter.entityToViewModel(pedido));
                } catch (PedidoException e) {
                    e.printStackTrace();
                }
            });
            cozinheiro.getListaIngredientesPizzaCozinheiro().forEach(ingrediente -> {
                try {
                    ingredienteVMList.add(IngredienteVMAdapter.entityToViewModel(ingrediente));
                } catch (IngredienteException e) {
                    e.printStackTrace();
                }
            });
            return cozinheiroVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Cozinheiro para CozinheiroModel");
            throw new CozinheiroException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Cozinheiro is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<CozinheiroVM> entityListToViewModelList(List<Cozinheiro> cozinheiroList) {
        List<CozinheiroVM> cozinheiroVMList = new ArrayList<>();
        cozinheiroList.forEach(cozinheiro -> {
            try {
                cozinheiroVMList.add(entityToViewModel(cozinheiro));
            } catch (CozinheiroException e) {
                e.printStackTrace();
            }
        });
        return cozinheiroVMList;
    }

    public static List<Cozinheiro> viewModelListToEntityList(List<CozinheiroVM> cozinheiroVMList) {
        List<Cozinheiro> cozinheiroList = new ArrayList<>();
        cozinheiroVMList.forEach(cozinheiroVM -> {
            try {
                cozinheiroList.add(viewModelToEntity(cozinheiroVM));
            } catch (CozinheiroException e) {
                e.printStackTrace();
            }
        });
        return cozinheiroList;
    }

}

