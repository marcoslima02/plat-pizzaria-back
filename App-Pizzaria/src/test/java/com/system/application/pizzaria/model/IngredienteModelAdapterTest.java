package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.external.database.entity.adapter.IngredienteModelAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredienteModelAdapterTest {


    private Ingrediente ingredienteToProcess = criaEntidadeIngrediente();
    private IngredienteModel ingredienteModelToProcess = criaEntidadeIngredienteModel();


    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws IngredienteException {
        //Arrange
        Ingrediente ingredienteExpected = criaEntidadeIngrediente();
        //Act
        Ingrediente ingredienteActual = IngredienteModelAdapter.modelToEntity(ingredienteModelToProcess);
        //Assert
        assertEquals(ingredienteExpected, ingredienteActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModel() throws IngredienteException {
        //Arrange
        IngredienteModel ingredienteModelExpected = criaEntidadeIngredienteModel();
        //Act
        IngredienteModel ingredienteModelActual = IngredienteModelAdapter.entityToModel(ingredienteToProcess);
        //Assert
        assertEquals(ingredienteModelExpected, ingredienteModelActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            IngredienteModelAdapter.entityToModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToModel Ingrediente is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            IngredienteModelAdapter.modelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter modelToEntity Ingrediente is Null", e.getMessage());
        }
    }

    public Ingrediente criaEntidadeIngrediente() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNomeIngrediente("Calabresa");
        ingrediente.setQuantidadeIngrediente(3);
        ingrediente.setPrecoIngrediente(new BigDecimal(3.99));

        return ingrediente;
    }

    public IngredienteModel criaEntidadeIngredienteModel() {
        IngredienteModel ingredienteModel = new IngredienteModel();
        ingredienteModel.setIdIngredienteModel(1);
        ingredienteModel.setNomeIngredienteModel("Calabresa");
        ingredienteModel.setQuantidadeIngredienteModel(3);
        ingredienteModel.setPrecoIngredienteModel(new BigDecimal(3.99));

        return ingredienteModel;
    }
}
