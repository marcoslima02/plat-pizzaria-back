package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.external.database.entity.PizzaModel;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.PizzaCadastroVM;
import com.system.application.pizzaria.viewmodel.adapter.IngredienteVMAdapter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaCadastroModelAdapter {

    public static Pizza modelToEntity(PizzaModel pizzaModel) throws PizzaException {
        Pizza pizza = new Pizza();
        List<Ingrediente> listIngrediente = new ArrayList<>();
        try {
            pizza.setIdPizza(pizzaModel.getIdPizzaModel());
            pizza.setNomePizza(pizzaModel.getNomePizzaModel());
            pizza.setPrecoPizza(pizzaModel.getPrecoPizzaModel());
            pizza.setQuantidadePizza(pizzaModel.getQuantidadePizzaModel());
            pizza.setCategoriaPizza(pizzaModel.getCategoriaPizzaModel());
            percorreListaIngredienteModelToEntity(pizzaModel, listIngrediente);
            pizza.setListaIngredientesPizza(listIngrediente);
            return pizza;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaCadastroModel para PizzaCadastro");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter modelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static PizzaModel entityToModel(Pizza pizza) throws PizzaException {
        PizzaModel pizzaModel = new PizzaModel();
        List<IngredienteModel> ingredienteListaModel = new ArrayList<>();
        try {
            pizzaModel.setIdPizzaModel(pizza.getIdPizza());
            pizzaModel.setNomePizzaModel(pizza.getNomePizza());
            pizzaModel.setPrecoPizzaModel(pizza.getPrecoPizza());
            pizzaModel.setQuantidadePizzaModel(pizza.getQuantidadePizza());
            pizzaModel.setCategoriaPizzaModel(pizza.getCategoriaPizza());
            percorreListaIngredienteEntityToModel(pizza, ingredienteListaModel);
            pizzaModel.setListaIngredientesPizzaModel(ingredienteListaModel);

            return pizzaModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaCadastro para PizzaCadastroModel");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter entityToModel Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void percorreListaIngredienteModelToEntity(PizzaModel pizzaModel, List<Ingrediente> ingredienteList) {
        pizzaModel.getListaIngredientesPizzaModel().forEach(ingredienteModel -> {
            try {
                ingredienteList.add(IngredienteModelAdapter.modelToEntity(ingredienteModel));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreListaIngredienteEntityToModel(Pizza pizza, List<IngredienteModel> ingredienteModelList) {
        pizza.getListaIngredientesPizza().forEach(ingrediente -> {
            try {
                ingredienteModelList.add(IngredienteModelAdapter.entityToModel(ingrediente));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }
}
