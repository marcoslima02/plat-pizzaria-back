package com.system.application.pizzaria.external.database.entity.adapter;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.external.database.entity.PizzaModel;
import com.system.application.pizzaria.util.ConfigUtils;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaModelAdapter {

    public static Pizza modelToEntity(PizzaModel pizzaModel) throws PizzaException {
        Pizza pizza = new Pizza();
        List<Ingrediente> ingredienteList = new ArrayList<>();
        try {
            pizza.setIdPizza(pizzaModel.getIdPizzaModel());
            pizza.setPrecoPizza(pizzaModel.getPrecoPizzaModel());
            pizzaModel.getListaIngredientesPizzaModelPizzaModel().forEach(ingredienteModel -> {
                try {
                    ingredienteList.add(IngredienteModelAdapter.modelToEntity(ingredienteModel));
                } catch (IngredienteException e) {
                    e.printStackTrace();
                }
            });
            pizza.setListaIngredientesPizza(ingredienteList);
            pizza.setCategoriaPizza(pizzaModel.getCategoriaPizzaModel());
            return pizza;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaModel para Pizza");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter modelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static PizzaModel entityToModel(Pizza pizza) throws PizzaException {
        PizzaModel pizzaModel = new PizzaModel();
        List<IngredienteModel> ingredienteModelList = new ArrayList<>();
        try {
            pizzaModel.setIdPizzaModel(pizza.getIdPizza());
            pizzaModel.setPrecoPizzaModel(pizza.getPrecoPizza());
            pizza.getListaIngredientesPizza().forEach(ingrediente -> {
                try {
                    ingredienteModelList.add(IngredienteModelAdapter.entityToModel(ingrediente));
                } catch (IngredienteException e) {
                    e.printStackTrace();
                }
            });
            pizzaModel.setListaIngredientesPizzaModelPizzaModel(ingredienteModelList);
            pizzaModel.setCategoriaPizzaModel(pizza.getCategoriaPizza());

            return pizzaModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pizza para PizzaModel");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter entityToModel Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<PizzaModel> entityListToModelList(List<Pizza> pizzaList) {
        List<PizzaModel> pizzaModelList = new ArrayList<>();
        pizzaList.forEach(pizza -> {
            try {
                pizzaModelList.add(entityToModel(pizza));
            } catch (PizzaException e) {
                e.printStackTrace();
            }
        });
        return pizzaModelList;
    }

    public static List<Pizza> modelListToEntityList(List<PizzaModel> pizzaModelList) {
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaModelList.forEach(pizzaModel -> {
            try {
                pizzaList.add(modelToEntity(pizzaModel));
            } catch (PizzaException e) {
                e.printStackTrace();
            }
        });
        return pizzaList;
    }

}
