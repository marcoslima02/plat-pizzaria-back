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
            cozinheiro.setNome(cozinheiroVM.getNomeVM());
            cozinheiro.setCpf(cozinheiroVM.getCpfVM());
            cozinheiro.setApelido(cozinheiroVM.getApelidoVM());
            cozinheiro.setSenha(cozinheiroVM.getSenhaVM());
            cozinheiro.setTelefone(cozinheiroVM.getTelefoneVM());
            cozinheiro.setHorarioTrabalho(cozinheiroVM.getHorarioTrabalhoVM());
            cozinheiro.setSalario(cozinheiroVM.getSalarioVM());
            validateIsNullVMToEntity(cozinheiroVM, pedidoList, ingredienteList);
            cozinheiro.setListaPedidoCozinheiro(pedidoList);
            cozinheiro.setListaIngredientesPizzaCozinheiro(ingredienteList);
            return cozinheiro;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de CozinheiroModel para Cozinheiro");
            throw new CozinheiroException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Cozinheiro is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateIsNullVMToEntity(CozinheiroVM cozinheiroVM, List<Pedido> pedidoList, List<Ingrediente> ingredienteList) {
        if(cozinheiroVM.getListaPedidoVMCozinheiroVM() != null){
            percorreListaPedidoVM(cozinheiroVM, pedidoList);
        }
        if(cozinheiroVM.getListaIngredientesPizzaVMCozinheiroVM() != null){
            percorreListaIngredienteVM(cozinheiroVM, ingredienteList);
        }
    }

    private static void percorreListaIngredienteVM(CozinheiroVM cozinheiroVM, List<Ingrediente> ingredienteList) {
        cozinheiroVM.getListaIngredientesPizzaVMCozinheiroVM().forEach(ingredienteVM -> {
            try {
                ingredienteList.add(IngredienteVMAdapter.viewModelToEntity(ingredienteVM));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreListaPedidoVM(CozinheiroVM cozinheiroVM, List<Pedido> pedidoList) {
        cozinheiroVM.getListaPedidoVMCozinheiroVM().forEach(pedidoVM -> {
            try {
                pedidoList.add(PedidoVMAdapter.viewModelToEntity(pedidoVM));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
    }

    public static CozinheiroVM entityToViewModel(Cozinheiro cozinheiro) throws CozinheiroException {
        CozinheiroVM cozinheiroVM = new CozinheiroVM();
        List<PedidoVM> pedidoVMList = new ArrayList<>();
        List<IngredienteVM> ingredienteVMList = new ArrayList<>();

        try {
            cozinheiroVM.setIdCozinheiroVM(cozinheiro.getIdCozinheiro());
            cozinheiroVM.setIdCozinheiroVM(cozinheiro.getIdCozinheiro());
            cozinheiroVM.setNomeVM(cozinheiro.getNome());
            cozinheiroVM.setCpfVM(cozinheiro.getCpf());
            cozinheiroVM.setApelidoVM(cozinheiro.getApelido());
            cozinheiroVM.setSenhaVM(cozinheiro.getSenha());
            cozinheiroVM.setTelefoneVM(cozinheiro.getTelefone());
            cozinheiroVM.setHorarioTrabalhoVM(cozinheiro.getHorarioTrabalho());
            cozinheiroVM.setSalarioVM(cozinheiro.getSalario());
            cozinheiroVM.setIdCozinheiroVM(cozinheiro.getIdCozinheiro());
            validateIsNullEntityToVM(cozinheiro, pedidoVMList, ingredienteVMList);
            cozinheiroVM.setListaPedidoVMCozinheiroVM(pedidoVMList);
            cozinheiroVM.setListaIngredientesPizzaVMCozinheiroVM(ingredienteVMList);
            return cozinheiroVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Cozinheiro para CozinheiroModel");
            throw new CozinheiroException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Cozinheiro is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateIsNullEntityToVM(Cozinheiro cozinheiro, List<PedidoVM> pedidoVMList, List<IngredienteVM> ingredienteVMList) {
        if(cozinheiro.getListaPedidoCozinheiro() != null){
            percorreListaPedidoEntity(cozinheiro, pedidoVMList);
        }
        if(cozinheiro.getListaIngredientesPizzaCozinheiro() != null){
            percorreListaIngredienteEntity(cozinheiro, ingredienteVMList);
        }
    }

    private static void percorreListaIngredienteEntity(Cozinheiro cozinheiro, List<IngredienteVM> ingredienteVMList) {
        cozinheiro.getListaIngredientesPizzaCozinheiro().forEach(ingrediente -> {
            try {
                ingredienteVMList.add(IngredienteVMAdapter.entityToViewModel(ingrediente));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreListaPedidoEntity(Cozinheiro cozinheiro, List<PedidoVM> pedidoVMList) {
        cozinheiro.getListaPedidoCozinheiro().forEach(pedido -> {
            try {
                pedidoVMList.add(PedidoVMAdapter.entityToViewModel(pedido));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
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

