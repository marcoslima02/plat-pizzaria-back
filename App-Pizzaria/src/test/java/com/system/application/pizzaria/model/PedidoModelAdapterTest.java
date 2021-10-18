package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.Pizza;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.external.database.entity.BebidaModel;
import com.system.application.pizzaria.external.database.entity.PedidoModel;
import com.system.application.pizzaria.external.database.entity.PizzaModel;
import com.system.application.pizzaria.external.database.entity.adapter.PedidoModelAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoModelAdapterTest {
    private PedidoModel pedidoModel = criaEntidadePedidoModel();
    private Pedido pedido = criaEntidadePedido();

    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws PedidoException {
        //Arrange
        Pedido pedidoExpected = criaEntidadePedido();
        //Act
        Pedido pedidoActual = PedidoModelAdapter.modelToEntity(pedidoModel);
        //Assert
        assertEquals(pedidoExpected, pedidoActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModel() throws PedidoException {
        //Arrange
        PedidoModel pedidoModelExpected = criaEntidadePedidoModel();
        //Act
        PedidoModel pedidoModelActual = PedidoModelAdapter.entityToModel(pedido);
        //Assert
        Assertions.assertEquals(pedidoModelExpected, pedidoModelActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            PedidoModelAdapter.entityToModel(null);
        } catch (PedidoException e) {
            Assertions.assertEquals("Adapter entityToModel Pedido is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            PedidoModelAdapter.modelToEntity(null);
        } catch (PedidoException e) {
            Assertions.assertEquals("Adapter modelToEntity Pedido is Null", e.getMessage());
        }
    }


    private Pedido criaEntidadePedido() {
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

    private PedidoModel criaEntidadePedidoModel() {
        PedidoModel pedidoModel = new PedidoModel();
        List<PizzaModel> listPizzaModel = new ArrayList<>();
        List<BebidaModel> listBebidaModel = new ArrayList<>();
        pedidoModel.setIdPedidoModel(1);
        pedidoModel.setStatusPedidoModel(StatusPedido.AGUARDANDO);
        pedidoModel.setListaPizzaModelPedidoModel(listPizzaModel);
        pedidoModel.setListaBebidaModelPedidoModel(listBebidaModel);
        pedidoModel.setHorarioPedidoModel(LocalDateTime.now());
        pedidoModel.setHorarioEstimadoPedidoModel(LocalDateTime.now());
        pedidoModel.setPrecoPedidoModel(new BigDecimal("59.00"));
        pedidoModel.setComentarioPedidoModel("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");

        PizzaModel pizzaModel = new PizzaModel();
        pizzaModel.setIdPizzaModel(1);
        pizzaModel.setPrecoPizzaModel(new BigDecimal("59.00"));
        //pizzaModel.setListaIngredientesPizzaModel();
        pizzaModel.setCategoriaPizzaModel(CategoriaPizza.LIGHT);

        BebidaModel bebidaModel = new BebidaModel();
        bebidaModel.setIdBebidaModel(1);
        bebidaModel.setNomeBebidaModel("Sua mãe");
        bebidaModel.setQuantidadeBebidaModel(17);
        bebidaModel.setPrecoBebidaModel(new BigDecimal("59.00"));

        listPizzaModel.add(pizzaModel);
        listBebidaModel.add(bebidaModel);

        return pedidoModel;
    }


}
