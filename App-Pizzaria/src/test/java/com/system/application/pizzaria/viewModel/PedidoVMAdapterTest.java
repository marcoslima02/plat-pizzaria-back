package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.PedidoVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import com.system.application.pizzaria.viewmodel.adapter.PedidoVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PedidoVMAdapterTest {

    private Pedido pedido = criaEntidadePedido();
    private PedidoVM pedidoVM = criaEntidadePedidoVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws PedidoException {
        //Arrange
        Pedido pedidoExpected = criaEntidadePedido();
        //Act
        Pedido pedidoActual = PedidoVMAdapter.viewModelToEntity(pedidoVM);
        //Assert
        assertEquals(pedidoExpected, pedidoActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() throws PedidoException {
        //Arrange
        PedidoVM pedidoVMExpected = criaEntidadePedidoVM();
        //Act
        PedidoVM pedidoVMActual = PedidoVMAdapter.entityToViewModel(pedido);
        //Assert
        assertEquals(pedidoVMExpected, pedidoVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            PedidoVMAdapter.entityToViewModel(null);
        } catch (PedidoException e) {
            assertEquals("Adapter entityToViewModel Pedido is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithViewModelNullTest() {
        //Act
        try {
            PedidoVMAdapter.viewModelToEntity(null);
        } catch (PedidoException e) {
            assertEquals("Adapter viewModelToEntity Pedido is Null", e.getMessage());
        }
    }

    public Pedido criaEntidadePedido() {
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

        return pedido;
    }

    public PedidoVM criaEntidadePedidoVM() {
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

        return pedidoVM;
    }

}
