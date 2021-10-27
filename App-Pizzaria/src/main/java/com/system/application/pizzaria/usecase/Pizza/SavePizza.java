package com.system.application.pizzaria.usecase.Pizza;

import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.PizzaPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePizza {

    @Autowired
    private PizzaPersistenceDataBase pizzaPersistenceDataBase;

    public Pizza savePizza(Pizza pizza) throws PizzaException {
        return pizzaPersistenceDataBase.savePizza(pizza);
    }

}
