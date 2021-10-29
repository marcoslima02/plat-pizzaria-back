package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.exception.IngredienteException;

import java.util.List;

public interface IngredientePersistenceDataBase {

    List<Ingrediente> getAllIngredientes();

    Ingrediente getIngredienteById(Integer idIngrediente) throws IngredienteException;
    Ingrediente saveIngrediente(Ingrediente ingrediente) throws IngredienteException;

}

