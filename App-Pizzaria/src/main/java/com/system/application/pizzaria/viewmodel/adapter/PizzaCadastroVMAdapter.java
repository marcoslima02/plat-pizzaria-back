package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import com.system.application.pizzaria.viewmodel.PizzaCadastroVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaCadastroVMAdapter {


    public static Pizza viewModelToEntity(PizzaCadastroVM pizzaCadastroVM) throws PizzaException {
        Pizza pizza = new Pizza();
        List<Ingrediente> listIngrediente = new ArrayList<>();
        try {
            pizza.setCategoriaPizza(pizzaCadastroVM.getCategoriaPizzaCadastroVM());
            pizza.setPrecoPizza(pizzaCadastroVM.getPrecoPizzaCadastroVM());
            pizza.setNomePizza(pizzaCadastroVM.getNomePizzaCadastroVM());
            pizza.setQuantidadePizza(pizzaCadastroVM.getQuantidadePizzaCadastroVM());
            percorreIngredienteVMToEntity(pizzaCadastroVM, listIngrediente);
            pizza.setListaIngredientesPizza(listIngrediente);


        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaCadastroVM para Pizza");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return pizza;
    }

    public static PizzaCadastroVM entityToViewModel(Pizza pizza) throws PizzaException {
        PizzaCadastroVM pizzaCadastroVM = new PizzaCadastroVM();
        List<IngredienteVM> ingredienteList = new ArrayList<>();
        try {
            pizzaCadastroVM.setCategoriaPizzaCadastroVM(pizza.getCategoriaPizza());
            pizzaCadastroVM.setPrecoPizzaCadastroVM(pizza.getPrecoPizza());
            pizzaCadastroVM.setNomePizzaCadastroVM(pizza.getNomePizza());
            pizzaCadastroVM.setQuantidadePizzaCadastroVM(pizza.getQuantidadePizza());
            percorreIngredienteEntityToVM(pizza, ingredienteList);
            pizzaCadastroVM.setListaIngredientesPizzaCadastroVM(ingredienteList);

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pizza para PizzaCadastroVM");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return pizzaCadastroVM;
    }

    private static void percorreIngredienteVMToEntity(PizzaCadastroVM pizzaCadastroVM, List<Ingrediente> ingredienteList) {
        pizzaCadastroVM.getListaIngredientesPizzaCadastroVM().forEach(ingredienteVM -> {
            try {
                ingredienteList.add(IngredienteVMAdapter.viewModelToEntity(ingredienteVM));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }

    private static void percorreIngredienteEntityToVM(Pizza pizza, List<IngredienteVM> ingredienteList) {
        pizza.getListaIngredientesPizza().forEach(ingrediente -> {
            try {
                ingredienteList.add(IngredienteVMAdapter.entityToViewModel(ingrediente));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }

}

