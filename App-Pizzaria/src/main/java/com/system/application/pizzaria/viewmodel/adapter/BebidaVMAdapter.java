package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.EnderecoVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BebidaVMAdapter {
    public static BebidaVM entityToViewModel(Bebida bebida) throws BebidaException {
        try {
            BebidaVM bebidaVM = new BebidaVM();
            bebidaVM.setIdBebidaVM(bebida.getIdBebida());
            bebidaVM.setNomeBebidaVM(bebida.getNomeBebida());
            bebidaVM.setQuantidadeBebidaVM(bebida.getQuantidadeBebida());
            bebidaVM.setPrecoBebidaVM(bebida.getPrecoBebida());
            return bebidaVM;
        } catch (Exception e) {
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter entityToVM Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Bebida viewModelToEntity(BebidaVM bebidaVM) throws BebidaException {
        try{
            Bebida bebida = new Bebida();
            bebida.setIdBebida(bebidaVM.getIdBebidaVM());
            bebida.setNomeBebida(bebidaVM.getNomeBebidaVM());
            bebida.setQuantidadeBebida(bebidaVM.getQuantidadeBebidaVM());
            bebida.setPrecoBebida(bebidaVM.getPrecoBebidaVM());
            return bebida;
        }catch (Exception e){
            throw new BebidaException(ErrorType.VALIDATIONS, "Adapter VMToEntity Bebida is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Bebida> viewModelListToEntityList(List<BebidaVM> bebidaVMList){
        List<Bebida> bebidaList = new ArrayList<>();
        bebidaVMList.forEach(bebidaVM -> {
            try {
                bebidaList.add(viewModelToEntity(bebidaVM));
            } catch (BebidaException e) {
                e.printStackTrace();
            }
        });
        return bebidaList;
    }

    public static List<BebidaVM> entityListToViewModelList(List<Bebida> bebidaList){
        List<BebidaVM> bebidaVMList = new ArrayList<>();
        bebidaList.forEach(bebida -> {
            try {
                bebidaVMList.add(entityToViewModel(bebida));
            } catch (BebidaException e) {
                e.printStackTrace();
            }
        });
        return bebidaVMList;
    }
}

