package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.*;
import com.system.application.pizzaria.exception.CozinheiroException;
import com.system.application.pizzaria.external.database.entity.*;
import com.system.application.pizzaria.external.database.entity.adapter.CozinheiroModelAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CozinheiroModelAdapterTest {

    private CozinheiroModel cozinheiroModel = criaEntidadeCozinheiroModel();
    private Cozinheiro cozinheiro = criaEntidadeCozinheiro();

    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws CozinheiroException {
        //Arrange
        Cozinheiro cozinheiroExpected = criaEntidadeCozinheiro();
        //Act
        Cozinheiro cozinheiroActual = CozinheiroModelAdapter.modelToEntity(cozinheiroModel);
        //Assert
        assertEquals(cozinheiroExpected, cozinheiroActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModel() throws CozinheiroException {
        //Arrange
        CozinheiroModel cozinheiroModelExpected = criaEntidadeCozinheiroModel();
        //Act
        CozinheiroModel cozinheiroModelActual = CozinheiroModelAdapter.entityToModel(cozinheiro);
        //Assert
        Assertions.assertEquals(cozinheiroModelExpected, cozinheiroModelActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            CozinheiroModelAdapter.entityToModel(null);
        } catch (CozinheiroException e) {
            Assertions.assertEquals("Adapter entityToModel Cozinheiro is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            CozinheiroModelAdapter.modelToEntity(null);
        } catch (CozinheiroException e) {
            Assertions.assertEquals("Adapter modelToEntity Cozinheiro is Null", e.getMessage());
        }
    }


    private Cozinheiro criaEntidadeCozinheiro() {
        Cozinheiro cozinheiro = new Cozinheiro();
        List<Pedido> listPedido = new ArrayList<>();
        List<Ingrediente> listIngrediente = new ArrayList<>();

        return cozinheiro;
    }

    private CozinheiroModel criaEntidadeCozinheiroModel() {
        CozinheiroModel cozinheiroModel = new CozinheiroModel();
        List<PedidoModel> listPedidoModel = new ArrayList<>();
        List<IngredienteModel> listIngredienteModel = new ArrayList<>();

        return cozinheiroModel;
    }

}
