package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.external.database.entity.PizzaModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaCadastroModelAdapter {

    public static Pizza modelToEntity(PizzaModel pizzaModel) throws PizzaException {
        Pizza pizza = new Pizza();
        List<Ingrediente> listaIngrediente = new ArrayList<>();
        try {
            pizza.setIdPizza(pizzaModel.getIdPizzaModel());
            pizza.setCategoriaPizza(pizzaModel.getCategoriaPizzaModel());
            pizza.setPrecoPizza(pizzaModel.getPrecoPizzaModel());
            pizza.setListaIngredientesPizza(listaIngrediente);
            return pizza;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaCadastroModel para PizzaCadastro");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter modelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static PizzaModel entityToModel(Pizza pizza) throws PizzaException {
        PizzaModel pizzaModel = new PizzaModel();
        List<IngredienteModel> listaIngredienteModel = new ArrayList<>();
        try {
            pizzaModel.setIdPizzaModel(pizza.getIdPizza());
            pizzaModel.setCategoriaPizzaModel(pizza.getCategoriaPizza());
            pizzaModel.setPrecoPizzaModel(pizza.getPrecoPizza());
            pizzaModel.setListaIngredientesPizzaModelPizzaModel(listaIngredienteModel);
            return pizzaModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaCadastro para PizzaCadastroModel");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter entityToModel Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
