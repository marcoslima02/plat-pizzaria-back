package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.external.database.entity.BebidaModel;
import com.system.application.pizzaria.external.database.entity.adapter.BebidaModelAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class BebidaModelAdapterTest {
    private BebidaModel bebidaModel = criaEntidadeBebidaModel();
    private Bebida bebida = criaEntidadeBebida();

    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws BebidaException {
        //Arrange
        Bebida bebidaExpected = criaEntidadeBebida();
        //Act
        Bebida bebidaActual = BebidaModelAdapter.modelToEntity(bebidaModel);
        //Assert
        assertEquals(bebidaExpected, bebidaActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModel() throws BebidaException {
        //Arrange
        BebidaModel bebidaModelExpected = criaEntidadeBebidaModel();
        //Act
        BebidaModel bebidaModelActual = BebidaModelAdapter.entityToModel(bebida);
        //Assert
        Assertions.assertEquals(bebidaModelExpected, bebidaModelActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            BebidaModelAdapter.entityToModel(null);
        } catch (BebidaException e) {
            Assertions.assertEquals("Adapter entityToModel Bebida is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            BebidaModelAdapter.modelToEntity(null);
        } catch (Exception e) {
            Assertions.assertEquals("Adapter modelToEntity Bebida is Null", e.getMessage());
        }
    }


    private Bebida criaEntidadeBebida() {
        Bebida bebida = new Bebida();
        bebida.setIdBebida(1);
        bebida.setNomeBebida("Sua mãe");
        bebida.setQuantidadeBebida(17);
        bebida.setPrecoBebida(new BigDecimal("59.00"));
        return bebida;
    }

    private BebidaModel criaEntidadeBebidaModel() {
        BebidaModel bebidaModel = new BebidaModel();
        bebidaModel.setIdBebidaModel(1);
        bebidaModel.setNomeBebidaModel("Sua mãe");
        bebidaModel.setQuantidadeBebidaModel(17);
        bebidaModel.setPrecoBebidaModel(new BigDecimal("59.00"));
        return bebidaModel;
    }

}