package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.database.entity.PedidoModel;
import com.system.application.pizzaria.external.database.entity.PizzaModel;
import com.system.application.pizzaria.external.database.entity.adapter.PizzaModelAdapter;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaModelAdapterTest {

    private PizzaModel pizzaModel = criaEntidadeModel();

    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws PizzaException {
        //Arrange
        Pizza pizzaExpected = criaEntidade();
        //Act
        Pizza pizzaActual = PizzaModelAdapter.modelToEntity(pizzaModel);
        //Assert
        assertEquals(pizzaExpected, pizzaActual);
    }

    private Pizza criaEntidade() {
        Pizza pizza = new Pizza();
        pizza.setIdPizza(1);
        pizza.setPrecoPizza(new BigDecimal("59.00"));
        pizza.setCategoriaPizza(CategoriaPizza.LIGHT);
        return pizza;
    }

    private PizzaModel criaEntidadeModel() {
        PizzaModel pizzaModel = new PizzaModel();
        pizzaModel.setIdPizzaModel(1);
        pizzaModel.setPrecoPizzaModel(new BigDecimal("59.00"));
        pizzaModel.setCategoriaPizzaModel(CategoriaPizza.LIGHT);
        return pizzaModel;
    }

}
