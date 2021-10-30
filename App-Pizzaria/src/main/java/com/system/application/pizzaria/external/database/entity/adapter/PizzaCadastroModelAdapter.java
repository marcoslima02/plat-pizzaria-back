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
        List<Ingrediente> listaIngrediente = new ArrayList<>();
        try {
            pizza.setIdPizza(pizzaModel.getIdPizzaModel());
            pizza.setNomePizza(pizzaModel.getNomePizzaModel());
            pizza.setPrecoPizza(pizzaModel.getPrecoPizzaModel());
            pizza.setQuantidadePizza(pizzaModel.getQuantidadePizzaModel());
            pizza.setCategoriaPizza(pizzaModel.getCategoriaPizzaModel());
            percorreListaIngrediente(pizzaModel, listaIngrediente);
            pizza.setListaIngredientesPizza(listaIngrediente);
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
            percorreListaIngrediente(pizza, ingredienteListaModel);
            pizzaModel.setListaIngredientesPizzaModelPizzaModel(ingredienteListaModel);

            return pizzaModel;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaCadastro para PizzaCadastroModel");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter entityToModel Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void percorreListaIngrediente(Pizza pizza, List<IngredienteModel> listaIngrediente) {
        pizza.getListaIngredientesPizza().forEach(ingrediente -> {
            try {
                listaIngrediente.add(IngredienteModelAdapter.entityToModel(ingrediente));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreListaIngrediente(PizzaModel pizzaModel, List<IngredienteModel> ingredienteListaModel) {
        pizzaModel.getListaIngredientesPizzaModelPizzaModel().forEach(ingrediente -> {
            try {
                ingredienteListaModel.add(IngredienteModelAdapter.entityToModel(ingrediente));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }

}
