package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.PizzaCadastroVM;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class PizzaCadastroVMAdapter {

    public static Pizza viewModelToEntity(PizzaCadastroVM pizzaCadastroVM) throws PizzaException {
        Pizza pizza = new Pizza();

        try {
            pizza.setCategoriaPizza(pizzaCadastroVM.getCategoriaPizzaCadastroVM());

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaCadastroVM para Pizza");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return pizza;
    }

    public static PizzaCadastroVM entityToViewModel(Pizza pizza) throws PizzaException {
        PizzaCadastroVM pizzaCadastroVM = new PizzaCadastroVM();
        try {
            pizzaCadastroVM.setCategoriaPizzaCadastroVM(pizza.getCategoriaPizza());

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pizza para PizzaCadastroVM");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return pizzaCadastroVM;
    }
}

