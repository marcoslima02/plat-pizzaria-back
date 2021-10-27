package com.system.application.pizzaria.viewModel;


import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.PedidoCadastroVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import com.system.application.pizzaria.viewmodel.adapter.PedidoCadastroVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PedidoCadastroVMAdapterTest {

    private PedidoCadastroVM pedidoCadastroVM = criaEntidadePedidoCadastroVM();

    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws PedidoException {
        //Arrange
        Pedido pedidoExpected = criaEntidadePedido();
        //Act
        Pedido pedidoActual = PedidoCadastroVMAdapter.viewModelToEntity(pedidoCadastroVM);
        //Assert
       // assertEquals(pedidoExpected, pedidoActual);
    }

    @Test
    public void shouldExceptionWithViewModelNullTest() {
        //Act
        try {
            PedidoCadastroVMAdapter.viewModelToEntity(null);
        } catch (PedidoException e) {
            //assertEquals("Adapter viewModelToEntity Pedido is Null", e.getMessage());
        }
    }

    public Pedido criaEntidadePedido() {

        List<Pizza> pizzaList = new ArrayList<>();
        List<Bebida> bebidaList = new ArrayList<>();

        Pizza pizza = new Pizza();
        pizza.setIdPizza(1);
        pizza.setNomePizza("Calabresa");
        pizza.setQuantidadePizza(2);
        pizza.setPrecoPizza(new BigDecimal(40.00));
        pizza.setCategoriaPizza(CategoriaPizza.TRADICIONAL);
        pizza.setListaIngredientesPizza(null);
        pizzaList.add(pizza);

        Bebida bebida = new Bebida();
        bebida.setNomeBebida("Coca");
        bebida.setPrecoBebida(new BigDecimal(19.00));
        bebida.setQuantidadeBebida(1);
        bebidaList.add(bebida);
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);
        pedido.setPrecoPedido(new BigDecimal("59.00"));
        pedido.setComentarioPedido("Tira tomate da Pizza");

        return pedido;
    }

    public PedidoCadastroVM criaEntidadePedidoCadastroVM() {
        List<PizzaVM> pizzaVMList = new ArrayList<>();
        List<BebidaVM> bebidaVMList = new ArrayList<>();

        PizzaVM pizzaVM = new PizzaVM();
        pizzaVM.setIdPizzaVM(1);
        pizzaVM.setNomePizzaVM("Calabresa");
        pizzaVM.setQuantidadePizzaVM(2);
        pizzaVM.setPrecoPizzaVM(new BigDecimal(40.00));
        pizzaVM.setCategoriaPizzaVM(CategoriaPizza.TRADICIONAL);
        pizzaVM.setListaIngredientesPizzaVM(null);
        pizzaVMList.add(pizzaVM);

        BebidaVM bebidaVM = new BebidaVM();
        bebidaVM.setNomeBebidaVM("Coca");
        bebidaVM.setPrecoBebidaVM(new BigDecimal(19.00));
        bebidaVM.setQuantidadeBebidaVM(1);
        bebidaVMList.add(bebidaVM);

        PedidoCadastroVM pedidoCadastroVM = new PedidoCadastroVM();
        pedidoCadastroVM.setPrecoTotalPedido(new BigDecimal("59.00"));
        pedidoCadastroVM.setComentarioPedidoCadastroVM("Tira tomate da Pizza");
        pedidoCadastroVM.setPizzaVMList(pizzaVMList);
        pedidoCadastroVM.setBebidaVMList(bebidaVMList);

        return pedidoCadastroVM;
    }
}
