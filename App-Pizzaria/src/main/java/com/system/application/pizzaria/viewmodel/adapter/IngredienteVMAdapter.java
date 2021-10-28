package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IngredienteVMAdapter {

    public static IngredienteVM entityToViewModel(Ingrediente ingrediente) throws IngredienteException {
        try {
            IngredienteVM ingredienteVM = new IngredienteVM();
            ingredienteVM.setIdIngredienteVM(ingrediente.getIdIngrediente());
            ingredienteVM.setNomeIngredienteVM(ingrediente.getNomeIngrediente());
            ingredienteVM.setQuantidadeIngredienteVM(ingrediente.getQuantidadeIngrediente());
            ingredienteVM.setPrecoIngredienteVM(ingrediente.getPrecoIngrediente());
            return ingredienteVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Ingrediente para IngredienteVM");
            throw new IngredienteException(ErrorType.VALIDATIONS, "Adapter entityToVM Ingrediente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Ingrediente viewModelToEntity(IngredienteVM ingredienteVM) throws IngredienteException {
        try{
            Ingrediente ingrediente = new Ingrediente();
            ingrediente.setIdIngrediente(ingredienteVM.getIdIngredienteVM());
            ingrediente.setNomeIngrediente(ingredienteVM.getNomeIngredienteVM());
            ingrediente.setQuantidadeIngrediente(ingredienteVM.getQuantidadeIngredienteVM());
            ingrediente.setPrecoIngrediente(ingredienteVM.getPrecoIngredienteVM());
            return ingrediente;
        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de IngredienteVM para Ingrediente");
            throw new IngredienteException(ErrorType.VALIDATIONS, "Adapter VMToEntity Ingrediente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Ingrediente> viewModelListToEntityList(List<IngredienteVM> ingredienteVMList){
        List<Ingrediente> ingredienteList = new ArrayList<>();
        ingredienteVMList.forEach(ingredienteVM -> {
            try {
                ingredienteList.add(viewModelToEntity(ingredienteVM));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
        return ingredienteList;
    }

    public static List<IngredienteVM> entityListToViewModelList(List<Ingrediente> ingredienteList) {
        List<IngredienteVM> ingredienteVMList = new ArrayList<>();
        ingredienteList.forEach(ingrediente -> {
            try {
                ingredienteVMList.add(entityToViewModel(ingrediente));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
        return ingredienteVMList;
    }

}
