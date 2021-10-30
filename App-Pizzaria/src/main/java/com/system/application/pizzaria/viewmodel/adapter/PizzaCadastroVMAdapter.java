package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.PizzaCadastroVM;
import com.system.application.pizzaria.viewmodel.cadastro.PedidoCadastroVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PizzaCadastroVMAdapter {

    public static Pizza viewModelToEntity(PizzaCadastroVM pizzaCadastroVM) throws PizzaException {
        Pizza pizza = new Pizza();
        List<Ingrediente> ingredienteList = new ArrayList<>();
        try {
            pizza.setCategoriaPizza(pizzaCadastroVM.getCategoriaPizzaCadastroVM());
            pizza.setPrecoPizza(pizzaCadastroVM.getPrecoPizzaCadastroVM());
            pizza.setNomePizza(pizzaCadastroVM.getNomePizzaCadastroVM());
            pizza.setQuantidadePizza(pizzaCadastroVM.getQuantidadePizzaCadastroVM());
            percorreListaIngrediente(pizzaCadastroVM, ingredienteList);
            pizza.setListaIngredientesPizza(ingredienteList);


        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de PizzaCadastroVM para Pizza");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return pizza;
    }

    public static PizzaCadastroVM entityToViewModel(Pizza pizza) throws PizzaException {
        PizzaCadastroVM pizzaCadastroVM = new PizzaCadastroVM();
        List<Ingrediente> ingredienteList = new ArrayList<>();
        try {
            pizzaCadastroVM.setCategoriaPizzaCadastroVM(pizza.getCategoriaPizza());
            pizzaCadastroVM.setPrecoPizzaCadastroVM(pizzaCadastroVM.getPrecoPizzaCadastroVM());
            pizzaCadastroVM.setNomePizzaCadastroVM(pizzaCadastroVM.getNomePizzaCadastroVM());
            pizzaCadastroVM.setQuantidadePizzaCadastroVM(pizzaCadastroVM.getQuantidadePizzaCadastroVM());
            percorreListaIngrediente(pizzaCadastroVM, ingredienteList);
            pizzaCadastroVM.setListaIngredientesPizzaCadastroVM(pizzaCadastroVM.getListaIngredientesPizzaCadastroVM());

        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Pizza para PizzaCadastroVM");
            throw new PizzaException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Pizza is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return pizzaCadastroVM;
    }

    private static void percorreListaIngrediente(PizzaCadastroVM pizzaCadastroVM, List<Ingrediente> listIngrediente) {
        pizzaCadastroVM.getListaIngredientesPizzaCadastroVM().forEach(ingredienteVM -> {
            try {
                listIngrediente.add(IngredienteVMAdapter.viewModelToEntity(ingredienteVM));
            } catch (IngredienteException e) {
                e.printStackTrace();
            }
        });
    }

}

