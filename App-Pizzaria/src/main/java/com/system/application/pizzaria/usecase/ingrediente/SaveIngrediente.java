package com.system.application.pizzaria.usecase.ingrediente;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.external.IngredientePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveIngrediente {

    @Autowired
    private IngredientePersistenceDataBase ingredientePersistenceDataBase;

    public Ingrediente saveIngrediente(Ingrediente ingrediente) throws IngredienteException {
        return ingredientePersistenceDataBase.saveIngrediente(ingrediente);
    }
}
