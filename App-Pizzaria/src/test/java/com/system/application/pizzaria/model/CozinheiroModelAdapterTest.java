package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.*;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.CozinheiroException;
import com.system.application.pizzaria.external.database.entity.*;
import com.system.application.pizzaria.external.database.entity.adapter.CozinheiroModelAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        cozinheiro.setIdCozinheiro(1);
        cozinheiro.setNome("Bolacha");
        cozinheiro.setCpf("431.654.989-60");
        cozinheiro.setApelido("Leo");
        cozinheiro.setSenha("leo123");
        cozinheiro.setTelefone("3219370234");
        cozinheiro.setSalario(new BigDecimal(6000.00));
        cozinheiro.setListaPedidoCozinheiro(listPedido);
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
        pizza.setListaIngredientesPizza(listIngrediente);
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

    private CozinheiroModel criaEntidadeCozinheiroModel() {
        CozinheiroModel cozinheiroModel = new CozinheiroModel();
        List<PedidoModel> listPedidoModel = new ArrayList<>();
        List<IngredienteModel> listIngredienteModel = new ArrayList<>();
        cozinheiroModel.setIdCozinheiroModel(1);
        cozinheiroModel.setNomeModel("Bolacha");
        cozinheiroModel.setCpfModel("431.654.989-60");
        cozinheiroModel.setApelidoModel("Leo");
        cozinheiroModel.setSenhaModel("leo123");
        cozinheiroModel.setTelefoneModel("3219370234");
        cozinheiroModel.setSalarioModel(new BigDecimal(6000.00));
        cozinheiroModel.setListaPedidoModelCozinheiroModel(listPedidoModel);
        cozinheiroModel.setListaIngredientesPizzaModelCozinheiroModel(listIngredienteModel);

        PedidoModel pedidoModel = new PedidoModel();
        List<PizzaModel> listPizzaModel = new ArrayList<>();
        List<BebidaModel> listBebidaModel = new ArrayList<>();
        pedidoModel.setIdPedidoModel(1);
        pedidoModel.setStatusPedidoModel(StatusPedido.AGUARDANDO);
        pedidoModel.setListaPizzaModel(listPizzaModel);
        pedidoModel.setListaBebidaModel(listBebidaModel);
        pedidoModel.setHorarioPedidoModel(LocalDateTime.now());
        pedidoModel.setHorarioEstimadoPedidoModel(LocalDateTime.now());
        pedidoModel.setPrecoPedidoModel(new BigDecimal("59.00"));
        pedidoModel.setComentarioPedidoModel("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");

        PizzaModel pizzaModel = new PizzaModel();
        pizzaModel.setIdPizzaModel(1);
        pizzaModel.setPrecoPizzaModel(new BigDecimal("59.00"));
        pizzaModel.setListaIngredientesPizzaModelPizzaModel(listIngredienteModel);
        pizzaModel.setCategoriaPizzaModel(CategoriaPizza.LIGHT);

        BebidaModel bebidaModel = new BebidaModel();
        bebidaModel.setIdBebidaModel(1);
        bebidaModel.setNomeBebidaModel("Sua mãe");
        bebidaModel.setQuantidadeBebidaModel(17);
        bebidaModel.setPrecoBebidaModel(new BigDecimal("59.00"));

        listPizzaModel.add(pizzaModel);
        listBebidaModel.add(bebidaModel);

        IngredienteModel ingredienteModel = new IngredienteModel();
        ingredienteModel.setIdIngredienteModel(1);
        ingredienteModel.setNomeIngredienteModel("Calabresa");
        ingredienteModel.setQuantidadeIngredienteModel(3);
        ingredienteModel.setPrecoIngredienteModel(new BigDecimal(3.99));

        listPedidoModel.add(pedidoModel);
        listIngredienteModel.add(ingredienteModel);
        return cozinheiroModel;
    }

}
