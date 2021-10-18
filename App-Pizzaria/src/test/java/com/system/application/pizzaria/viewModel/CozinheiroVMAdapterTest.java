package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.*;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.CozinheiroException;
import com.system.application.pizzaria.viewmodel.CozinheiroVM;
import com.system.application.pizzaria.viewmodel.PedidoVM;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.adapter.CozinheiroVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        cozinheiro.setIdCozinheiro(1);
        cozinheiro.setListaPizzaPedidoCozinheiro(listPedido);
        cozinheiro.setListaIngredientesPizzaCozinheiro(listIngrediente);

        Pedido pedido = new Pedido();
        List<Pizza> listPizza = new ArrayList<>();
        List<Bebida> listBebida = new ArrayList<>();
        pedido.setIdPedido(1);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);
        pedido.setListaPizzaPedido(listPizza);
        pedido.setListaBebidaPedido(listBebida);
        pedido.setHorarioPedido(LocalDateTime.now());
        pedido.setHorarioEstimadoPedido(LocalDateTime.now());
        pedido.setPrecoPedido(new BigDecimal("59.00"));
        pedido.setComentarioPedido("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");

        Pizza pizza = new Pizza();
        pizza.setIdPizza(1);
        pizza.setPrecoPizza(new BigDecimal("59.00"));
        //pizza.setListaIngredientesPizza();
        pizza.setCategoriaPizza(CategoriaPizza.LIGHT);

        Bebida bebida = new Bebida();
        bebida.setIdBebida(1);
        bebida.setNomeBebida("Sua mãe");
        bebida.setQuantidadeBebida(17);
        bebida.setPrecoBebida(new BigDecimal("59.00"));

        listPizza.add(pizza);
        listBebida.add(bebida);

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setNomeIngrediente("Calabresa");
        ingrediente.setQuantidadeIngrediente(3);
        ingrediente.setPrecoIngrediente(new BigDecimal(3.99));

        listPedido.add(pedido);
        listIngrediente.add(ingrediente);

        return cozinheiro;
    }

    private CozinheiroVM criaEntidadeCozinheiroVM() {
        CozinheiroVM cozinheiroVM = new CozinheiroVM();
        List<PedidoVM> listPedidoVM = new ArrayList<>();
        List<IngredienteVM> listIngredienteVM = new ArrayList<>();
        cozinheiroVM.setIdCozinheiroVM(1);
        cozinheiroVM.setListaPizzaPedidoVMCozinheiroVM(listPedidoVM);
        cozinheiroVM.setListaIngredientesPizzaVMCozinheiroVM(listIngredienteVM);

        PedidoVM pedidoVM = new PedidoVM();
        List<PizzaVM> listPizzaVM = new ArrayList<>();
        List<BebidaVM> listBebidaVM = new ArrayList<>();
        pedidoVM.setIdPedidoVM(1);
        pedidoVM.setStatusPedidoVM(StatusPedido.AGUARDANDO);
        pedidoVM.setListaPizzaVMPedidoVM(listPizzaVM);
        pedidoVM.setListaBebidaVMPedidoVM(listBebidaVM);
        pedidoVM.setHorarioPedidoVM(LocalDateTime.now());
        pedidoVM.setHorarioEstimadoPedidoVM(LocalDateTime.now());
        pedidoVM.setPrecoPedidoVM(new BigDecimal("59.00"));
        pedidoVM.setComentarioPedidoVM("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");

        PizzaVM pizzaVM = new PizzaVM();
        pizzaVM.setIdPizzaVM(1);
        pizzaVM.setPrecoPizzaVM(new BigDecimal("59.00"));
        //pizzaVM.setListaIngredientesPizzaVM();
        pizzaVM.setCategoriaPizzaVM(CategoriaPizza.LIGHT);

        BebidaVM bebidaVM = new BebidaVM();
        bebidaVM.setIdBebidaVM(1);
        bebidaVM.setNomeBebidaVM("Sua mãe");
        bebidaVM.setQuantidadeBebidaVM(17);
        bebidaVM.setPrecoBebidaVM(new BigDecimal("59.00"));

        listPizzaVM.add(pizzaVM);
        listBebidaVM.add(bebidaVM);

        IngredienteVM ingredienteVM = new IngredienteVM();
        ingredienteVM.setIdIngredienteVM(1);
        ingredienteVM.setNomeIngredienteVM("Calabresa");
        ingredienteVM.setQuantidadeIngredienteVM(3);
        ingredienteVM.setPrecoIngredienteVM(new BigDecimal(3.99));

        listPedidoVM.add(pedidoVM);
        listIngredienteVM.add(ingredienteVM);

        return cozinheiroVM;
    }

}
