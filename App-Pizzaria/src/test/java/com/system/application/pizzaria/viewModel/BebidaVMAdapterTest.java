package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.adapter.BebidaVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BebidaVMAdapterTest {

    private Bebida bebidaToProcess = criaEntidadeBebida();
    private BebidaVM bebidaVMToProcess = criaEntidadeBebidaVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws BebidaException {
        //Arrange
        Bebida bebidaExpected = criaEntidadeBebida();
        //Act
        Bebida bebidaActual = BebidaVMAdapter.viewModelToEntity(bebidaVMToProcess);
        //Assert
        assertEquals(bebidaExpected, bebidaActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() throws BebidaException {
        //Arrange
        BebidaVM bebidaVMExpected = criaEntidadeBebidaVM();
        //Act
        BebidaVM bebidaVMActual = BebidaVMAdapter.entityToViewModel(bebidaToProcess);
        //Assert
        assertEquals(bebidaVMExpected, bebidaVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            BebidaVMAdapter.entityToViewModel(null);
        } catch (BebidaException e) {
            assertEquals("Adapter entityToVM Bebida is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            BebidaVMAdapter.viewModelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter VMToEntity Bebida is Null", e.getMessage());
        }
    }

    public Bebida criaEntidadeBebida() {
        Bebida bebida = new Bebida();
        bebida.setIdBebida(1);
        bebida.setNomeBebida("Sua mãe");
        bebida.setQuantidadeBebida(17);
        bebida.setPrecoBebida(new BigDecimal("59.00"));
        return bebida;

    }

    public BebidaVM criaEntidadeBebidaVM() {
        BebidaVM bebidaVM = new BebidaVM();
        bebidaVM.setIdBebidaVM(1);
        bebidaVM.setNomeBebidaVM("Sua mãe");
        bebidaVM.setQuantidadeBebidaVM(17);
        bebidaVM.setPrecoBebidaVM(new BigDecimal("59.00"));
        return bebidaVM;

    }
}