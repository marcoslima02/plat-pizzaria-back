package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import com.system.application.pizzaria.viewmodel.adapter.IngredienteVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredienteVMAdapterTest {

    private Ingrediente ingredienteToProcess = criaEntidadeIngrediente();
    private IngredienteVM ingredienteVMToProcess = criaEntidadeIngredienteVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws IngredienteException {
        //Arrange
        Ingrediente ingredienteExpected = criaEntidadeIngrediente();
        //Act
        Ingrediente ingredienteActual = IngredienteVMAdapter.viewModelToEntity(ingredienteVMToProcess);
        //Assert
        assertEquals(ingredienteExpected, ingredienteActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() throws IngredienteException {
        //Arrange
        IngredienteVM ingredienteVMExpected = criaEntidadeIngredienteVM();
        //Act
        IngredienteVM ingredienteVMActual = IngredienteVMAdapter.entityToViewModel(ingredienteToProcess);
        //Assert
        assertEquals(ingredienteVMExpected, ingredienteVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            IngredienteVMAdapter.entityToViewModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToVM Ingrediente is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            IngredienteVMAdapter.viewModelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter VMToEntity Ingrediente is Null", e.getMessage());
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

    public IngredienteVM criaEntidadeIngredienteVM() {
        IngredienteVM ingredienteVM = new IngredienteVM();
        ingredienteVM.setIdIngredienteVM(1);
        ingredienteVM.setNomeIngredienteVM("Calabresa");
        ingredienteVM.setQuantidadeIngredienteVM(3);
        ingredienteVM.setPrecoIngredienteVM(new BigDecimal(3.99));
        return ingredienteVM;
    }
}
