package com.system.application.pizzaria.viewModel;


import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import com.system.application.pizzaria.viewmodel.cadastro.PedidoCadastroVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import com.system.application.pizzaria.viewmodel.adapter.forms.PedidoCadastroVMAdapter;
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
        assertEquals(pedidoExpected.getPrecoPedido(), pedidoActual.getPrecoPedido());
        assertEquals(pedidoExpected.getComentarioPedido(), pedidoActual.getComentarioPedido());
        assertEquals(pedidoExpected.getListaPizzaPedido(), pedidoActual.getListaPizzaPedido());
        assertEquals(pedidoExpected.getListaBebidaPedido(), pedidoActual.getListaBebidaPedido());
    }

    @Test
    public void shouldExceptionWithViewModelNullTest() {
        //Act
        try {
            PedidoCadastroVMAdapter.viewModelToEntity(null);
        } catch (PedidoException e) {
            assertEquals("Adapter viewModelToEntity Pedido is Null", e.getMessage());
        }
    }

    public Pedido criaEntidadePedido() {

        List<Pizza> pizzaList = new ArrayList<>();
        List<Bebida> bebidaList = new ArrayList<>();
        List<Ingrediente> listIntediente = new ArrayList<>();

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setPrecoIngrediente(new BigDecimal(3.00));
        ingrediente.setQuantidadeIngrediente(2);
        ingrediente.setNomeIngrediente("Tomate");
        listIntediente.add(ingrediente);

        Pizza pizza = new Pizza();
        pizza.setIdPizza(1);
        pizza.setNomePizza("Calabresa");
        pizza.setQuantidadePizza(2);
        pizza.setPrecoPizza(new BigDecimal(40.00));
        pizza.setCategoriaPizza(CategoriaPizza.TRADICIONAL);
        pizza.setListaIngredientesPizza(listIntediente);
        pizzaList.add(pizza);

        Bebida bebida = new Bebida();
        bebida.setNomeBebida("Coca");
        bebida.setPrecoBebida(new BigDecimal(19.00));
        bebida.setQuantidadeBebida(1);
        bebidaList.add(bebida);

        Pedido pedido = new Pedido();
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);
        pedido.setPrecoPedido(new BigDecimal("59.00"));
        pedido.setComentarioPedido("Tira tomate da Pizza");
        pedido.setListaPizzaPedido(pizzaList);
        pedido.setListaBebidaPedido(bebidaList);

        return pedido;
    }

    public PedidoCadastroVM criaEntidadePedidoCadastroVM() {
        List<PizzaVM> pizzaVMList = new ArrayList<>();
        List<BebidaVM> bebidaVMList = new ArrayList<>();
        List<IngredienteVM> listIntedienteVM = new ArrayList<>();

        IngredienteVM ingredienteVM = new IngredienteVM();
        ingredienteVM.setIdIngredienteVM(1);
        ingredienteVM.setPrecoIngredienteVM(new BigDecimal(3.00));
        ingredienteVM.setQuantidadeIngredienteVM(2);
        ingredienteVM.setNomeIngredienteVM("Tomate");
        listIntedienteVM.add(ingredienteVM);

        PizzaVM pizzaVM = new PizzaVM();
        pizzaVM.setIdPizzaVM(1);
        pizzaVM.setNomePizzaVM("Calabresa");
        pizzaVM.setQuantidadePizzaVM(2);
        pizzaVM.setPrecoPizzaVM(new BigDecimal(40.00));
        pizzaVM.setCategoriaPizzaVM(CategoriaPizza.TRADICIONAL);
        pizzaVM.setListaIngredientesPizzaVM(listIntedienteVM);
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
