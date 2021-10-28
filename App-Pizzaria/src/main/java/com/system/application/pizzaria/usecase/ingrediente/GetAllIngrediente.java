package com.system.application.pizzaria.usecase.ingrediente;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.external.IngredientePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllIngrediente {

    @Autowired
    private IngredientePersistenceDataBase ingredientePersistenceDataBase;

    public List<Ingrediente> getAllIngredientes(){
        return ingredientePersistenceDataBase.getAllIngredientes();
    }
}


