package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Cozinheiro;
import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.CozinheiroException;
import com.system.application.pizzaria.viewmodel.CozinheiroVM;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import com.system.application.pizzaria.viewmodel.PedidoVM;
import com.system.application.pizzaria.viewmodel.adapter.CozinheiroVMAdapter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CozinheiroVMAdapterTest {

    private Cozinheiro cozinheiro = criaEntidadeCozinheiro();
    private CozinheiroVM cozinheiroVM = criaEntidadeCozinheiroVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws CozinheiroException {
        //Arrange
        Cozinheiro cozinheiroExpected = criaEntidadeCozinheiro();
        //Act
        Cozinheiro cozinheiroActual = CozinheiroVMAdapter.viewModelToEntity(cozinheiroVM);
        //Assert
        assertEquals(cozinheiroExpected, cozinheiroActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() throws CozinheiroException {
        //Arrange
        CozinheiroVM cozinheiroVMExpected = criaEntidadeCozinheiroVM();
        //Act
        CozinheiroVM cozinheiroVMActual = CozinheiroVMAdapter.entityToViewModel(cozinheiro);
        //Assert
        assertEquals(cozinheiroVMExpected, cozinheiroVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            CozinheiroVMAdapter.entityToViewModel(null);
        } catch (CozinheiroException e) {
            assertEquals("Adapter entityToViewModel Cozinheiro is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithViewModelNullTest() {
        //Act
        try {
            CozinheiroVMAdapter.viewModelToEntity(null);
        } catch (CozinheiroException e) {
            assertEquals("Adapter viewModelToEntity Cozinheiro is Null", e.getMessage());
        }
    }


    private Cozinheiro criaEntidadeCozinheiro() {
        Cozinheiro cozinheiro = new Cozinheiro();
        List<Pedido> listPedido = new ArrayList<>();
        List<Ingrediente> listIngrediente = new ArrayList<>();

        return cozinheiro;
    }

    private CozinheiroVM criaEntidadeCozinheiroVM() {
        CozinheiroVM cozinheiroVM = new CozinheiroVM();
        List<PedidoVM> listPedidoVM = new ArrayList<>();
        List<IngredienteVM> listIngredienteVM = new ArrayList<>();

        return cozinheiroVM;
    }

}
