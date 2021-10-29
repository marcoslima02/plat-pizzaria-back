package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

public class IngredienteCadastroModelAdapter {
    public static Ingrediente modelToEntity(IngredienteModel ingredienteModel) throws IngredienteException {
        Ingrediente ingrediente = new Ingrediente();
        try {
            ingrediente.setIdIngrediente(ingredienteModel.getIdIngredienteModel());
            ingrediente.setNomeIngrediente(ingredienteModel.getNomeIngredienteModel());
            ingrediente.setQuantidadeIngrediente(ingredienteModel.getQuantidadeIngredienteModel());
            ingrediente.setPrecoIngrediente(ingredienteModel.getPrecoIngredienteModel());
            return ingrediente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de IngredienteCadastroModel para IngredienteCadastro");
            throw new IngredienteException(ErrorType.VALIDATIONS, "Adapter modelToEntity Ingrediente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static IngredienteModel entityToModel(Ingrediente ingrediente) throws IngredienteException {
        IngredienteModel ingredienteModel = new IngredienteModel();
        try {
            ingredienteModel.setIdIngredienteModel(ingrediente.getIdIngrediente());
            ingredienteModel.setNomeIngredienteModel(ingrediente.getNomeIngrediente());
            ingredienteModel.setQuantidadeIngredienteModel(ingrediente.getQuantidadeIngrediente());
            ingredienteModel.setPrecoIngredienteModel(ingrediente.getPrecoIngrediente());
            return ingredienteModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de IngredienteCadastro para IngredienteCadastroModel");
            throw new IngredienteException(ErrorType.VALIDATIONS, "Adapter entityToModel Ingrediente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
