package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import com.system.application.pizzaria.viewmodel.adapter.PizzaVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaVMAdapterTest {

    private Pizza pizzaToProcess = criaEntidadePizza();
    private PizzaVM pizzaVMToProcess = criaEntidadePizzaVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws PizzaException {
        //Arrange
        Pizza pizzaExpected = criaEntidadePizza();
        //Act
        Pizza pizzaActual = PizzaVMAdapter.viewModelToEntity(pizzaVMToProcess);
        //Assert
        assertEquals(pizzaExpected, pizzaActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() throws PizzaException {
        //Arrange
        PizzaVM pizzaVMExpected = criaEntidadePizzaVM();
        //Act
        PizzaVM pizzaVMActual = PizzaVMAdapter.entityToViewModel(pizzaToProcess);
        //Assert
        assertEquals(pizzaVMExpected, pizzaVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            PizzaVMAdapter.entityToViewModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToVM Pizza is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            PizzaVMAdapter.viewModelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter VMToEntity Pizza is Null", e.getMessage());
        }
    }

    public Pizza criaEntidadePizza() {
        Pizza pizza = new Pizza();
        List<Ingrediente> listIngrediente = new ArrayList<>();
        pizza.setIdPizza(1);
        pizza.setPrecoPizza(new BigDecimal(49.90));
        pizza.setListaIngredientesPizza(listIngrediente);
        pizza.setCategoriaPizza(CategoriaPizza.DOCE);

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNomeIngrediente("Calabresa");
        ingrediente.setQuantidadeIngrediente(3);
        ingrediente.setPrecoIngrediente(new BigDecimal(3.99));

        listIngrediente.add(ingrediente);
        return pizza;

    }

    public PizzaVM criaEntidadePizzaVM() {
        PizzaVM pizzaVM = new PizzaVM();
        List<IngredienteVM> listIngredienteVM = new ArrayList<>();
        pizzaVM.setIdPizzaVM(1);
        pizzaVM.setPrecoPizzaVM(new BigDecimal(49.90));
        pizzaVM.setListaIngredientesPizzaVM(listIngredienteVM);
        pizzaVM.setCategoriaPizzaVM(CategoriaPizza.DOCE);

        IngredienteVM ingredienteVM = new IngredienteVM();
        ingredienteVM.setIdIngredienteVM(1);
        ingredienteVM.setNomeIngredienteVM("Calabresa");
        ingredienteVM.setQuantidadeIngredienteVM(3);
        ingredienteVM.setPrecoIngredienteVM(new BigDecimal(3.99));

        listIngredienteVM.add(ingredienteVM);
        return pizzaVM;
    }
}
