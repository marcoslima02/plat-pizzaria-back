package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.exception.PizzaException;

import java.util.List;

public interface PizzaPersistenceDataBase {

    List<Pizza> getAllPizzas() throws PizzaException;

    Pizza getPizzaById(Integer idPizza) throws PizzaException;
}
