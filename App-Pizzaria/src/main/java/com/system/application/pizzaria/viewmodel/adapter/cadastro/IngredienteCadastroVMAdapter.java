package com.system.application.pizzaria.viewmodel.adapter.cadastro;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.cadastro.IngredienteCadastroVm;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class IngredienteCadastroVMAdapter {


    public static Ingrediente viewModelToEntity(IngredienteCadastroVm ingredienteCadastroVM) throws IngredienteException {
        Ingrediente ingrediente = new Ingrediente();
        try {
            ingrediente.setNomeIngrediente(ingredienteCadastroVM.getNomeIngredienteVM());
            ingrediente.setQuantidadeIngrediente(ingredienteCadastroVM.getQuantidadeIngredienteVM());
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de IngredienteCadastroVM para Ingrediente");
            throw new IngredienteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Ingrediente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ingrediente;
    }

    public static IngredienteCadastroVm entityToViewModel(Ingrediente ingrediente) throws IngredienteException {
        IngredienteCadastroVm ingredienteCadastroVM = new IngredienteCadastroVm();
        try {
            ingredienteCadastroVM.setNomeIngredienteVM(ingrediente.getNomeIngrediente());
            ingredienteCadastroVM.setQuantidadeIngredienteVM(ingrediente.getQuantidadeIngrediente());
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Ingrediente para IngredienteCadastroVM");
            throw new IngredienteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Ingrediente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ingredienteCadastroVM;
    }
}

