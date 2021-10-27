package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaVMAdapter {

    public static PizzaVM entityToViewModel(Pizza pizza) throws PizzaException {
        PizzaVM pizzaVM = new PizzaVM();
        List<IngredienteVM> ingredienteVMList = new ArrayList<>();
        try {
            pizzaVM.setIdPizzaVM(pizza.getIdPizza());
            pizzaVM.setPrecoPizzaVM(pizza.getPrecoPizza());
            pizzaVM.setCategoriaPizzaVM(pizza.getCategoriaPizza());
            pizza.getListaIngredientesPizza().forEach(ingrediente -> {
                try {
                    ingredienteVMList.add(IngredienteVMAdapter.entityToViewModel(ingrediente));
                } catch (IngredienteException e) {
                    e.printStackTrace();
                }
            });
            return pizzaVM;
        } catch (Exception e) {
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter entityToVM Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Pizza viewModelToEntity(PizzaVM pizzaVM) throws PizzaException {
        Pizza pizza = new Pizza();
        List<Ingrediente> ingredienteList = new ArrayList<>();
        try {
            pizza.setIdPizza(pizzaVM.getIdPizzaVM());
            pizza.setPrecoPizza(pizzaVM.getPrecoPizzaVM());
            pizza.setCategoriaPizza(pizzaVM.getCategoriaPizzaVM());
            pizzaVM.getListaIngredientesPizzaVM().forEach(ingredienteVM -> {
                try {
                    ingredienteList.add(IngredienteVMAdapter.viewModelToEntity(ingredienteVM));
                } catch (IngredienteException e) {
                    e.printStackTrace();
                }
            });
            return pizza;
        } catch (Exception e) {
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter VMToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Pizza> viewModelListToEntityList(List<PizzaVM> pizzaVMList) {
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaVMList.forEach(pizzaVM -> {
            try {
                pizzaList.add(viewModelToEntity(pizzaVM));
            } catch (PizzaException e) {
                e.printStackTrace();
            }
        });
        return pizzaList;
    }

    public static List<PizzaVM> entityListToEntityList(List<Pizza> pizzaList) {
        List<PizzaVM> pizzaVMList = new ArrayList<>();
        pizzaList.forEach(pizza -> {
            try {
                pizzaVMList.add(entityToViewModel(pizza));
            } catch (PizzaException e) {
                e.printStackTrace();
            }
        });
        return pizzaVMList;
    }

}
