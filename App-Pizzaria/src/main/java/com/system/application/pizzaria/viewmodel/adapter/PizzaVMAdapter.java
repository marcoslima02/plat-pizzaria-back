package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaVMAdapter {

    public static PizzaVM entityToViewModel(Pizza pizza) throws PizzaException {
        try {
            PizzaVM pizzaVM = new PizzaVM();
            pizzaVM.setIdPizzaVM(pizza.getIdPizza());
            pizzaVM.setPrecoPizzaVM(pizza.getPrecoPizza());
            pizzaVM.setListaIngredientesPizzaVM(pizza.getListaIngredientesPizza());
            pizzaVM.setCategoriaPizzaVM(pizza.getCategoriaPizza());
            return pizzaVM;
        } catch (Exception e) {
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter entityToVM Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Pizza viewModelToEntity(PizzaVM pizzaVM) throws pizzaException, PizzaException {
        try{
            Pizza pizza = new Pizza();
            pizza.setIdPizza(pizzaVM.getIdPizzaVM());
            pizza.setPrecoPizza(pizzaVM.getPrecoPizzaVM());
            pizza.setListaIngredientesPizza(pizzaVM.getListaIngredientesPizzaVM());
            pizza.setCategoriaPizza(pizzaVM.getCategoriaPizzaVM());

            return pizza;
        }catch (Exception e){
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter VMToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Pizza> viewModelListToEntityList(List<PizzaVM> pizzaVMList){
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

    public static List<PizzaVM> entityListToEntityList(List<Pizza> pizzaList){
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
