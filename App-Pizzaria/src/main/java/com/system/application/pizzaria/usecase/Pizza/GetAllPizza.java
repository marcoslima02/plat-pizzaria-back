package com.system.application.pizzaria.usecase.Pizza;

import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.PizzaPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllPizza {

    @Autowired
    private PizzaPersistenceDataBase pizzaPersistenceDataBase;

    public List<Pizza> getAllPizzas() throws PizzaException {
        return pizzaPersistenceDataBase.getAllPizzas();
    }
}
