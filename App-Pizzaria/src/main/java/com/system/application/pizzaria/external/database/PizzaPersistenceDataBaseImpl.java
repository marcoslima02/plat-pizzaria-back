package com.system.application.pizzaria.external.database;

import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.PizzaException;
import com.system.application.pizzaria.external.PizzaPersistenceDataBase;
import com.system.application.pizzaria.external.database.entity.PizzaModel;
import com.system.application.pizzaria.external.database.entity.adapter.PizzaModelAdapter;
import com.system.application.pizzaria.external.database.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PizzaPersistenceDataBaseImpl implements PizzaPersistenceDataBase {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public List<Pizza> getAllPizzas() {
        List<PizzaModel> pizzaModelList = pizzaRepository.findAll();
        return PizzaModelAdapter.modelListToEntityList(pizzaModelList);
    }

    @Override
    public Pizza getPizzaById(Integer idPizza) throws PizzaException {
        try {
            PizzaModel pizzaModel = pizzaRepository.getById(idPizza);
            return PizzaModelAdapter.modelToEntity(pizzaModel);
        } catch (Exception e) {
            throw new PizzaException(ErrorType.DATA_BASE_NOT_FOUND, String.format("DATABASE pizza NOT FOUND FOR ID: %d", idPizza), new Date(), HttpStatus.NOT_FOUND);
        }
    }
}
