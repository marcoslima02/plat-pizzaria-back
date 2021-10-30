package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.external.database.entity.PizzaModel;
import com.system.application.pizzaria.external.database.entity.adapter.PizzaModelAdapter;
import com.system.application.pizzaria.viewmodel.adapter.PizzaVMAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PizzaModelAdapterTest {

    private PizzaModel pizzaModel = criaEntidadePizzaModel();
    private Pizza pizza = criaEntidadePizza();

    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws PizzaException {
        //Arrange
        Pizza pizzaExpected = criaEntidadePizza();
        //Act
        Pizza pizzaActual = PizzaModelAdapter.modelToEntity(pizzaModel);
        //Assert
        assertEquals(pizzaExpected, pizzaActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModelTest() throws PizzaException {
        //Arrange
        PizzaModel pizzaModelExpected = criaEntidadePizzaModel();
        //Act
        PizzaModel pizzaModelActual = PizzaModelAdapter.entityToModel(pizza);
        //Assert
        assertEquals(pizzaModelExpected, pizzaModelActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            PizzaModelAdapter.entityToModel(null);
        } catch (Exception e) {
            Assertions.assertEquals("Adapter entityToModel Pizza is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            PizzaModelAdapter.modelToEntity(null);
        } catch (Exception e) {
            Assertions.assertEquals("Adapter modelToEntity Pizza is Null", e.getMessage());
        }
    }


    private Pizza criaEntidadePizza() {
        Pizza pizza = new Pizza();
        List<Ingrediente> listIngrediente = new ArrayList<>();
        pizza.setIdPizza(1);
        pizza.setPrecoPizza(new BigDecimal("59.00"));
        pizza.setListaIngredientesPizza(listIngrediente);
        pizza.setCategoriaPizza(CategoriaPizza.LIGHT);

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNomeIngrediente("Calabresa");
        ingrediente.setQuantidadeIngrediente(3);
        ingrediente.setPrecoIngrediente(new BigDecimal(3.99));

        listIngrediente.add(ingrediente);
        return pizza;
    }

    private PizzaModel criaEntidadePizzaModel() {
        PizzaModel pizzaModel = new PizzaModel();
        List<IngredienteModel> listIngredienteModel = new ArrayList<>();
        pizzaModel.setIdPizzaModel(1);
        pizzaModel.setPrecoPizzaModel(new BigDecimal("59.00"));
        pizzaModel.setListaIngredientesPizzaModel(listIngredienteModel);
        pizzaModel.setCategoriaPizzaModel(CategoriaPizza.LIGHT);

        IngredienteModel ingredienteModel = new IngredienteModel();
        ingredienteModel.setIdIngredienteModel(1);
        ingredienteModel.setNomeIngredienteModel("Calabresa");
        ingredienteModel.setQuantidadeIngredienteModel(3);
        ingredienteModel.setPrecoIngredienteModel(new BigDecimal(3.99));

        listIngredienteModel.add(ingredienteModel);
        return pizzaModel;
    }

}
