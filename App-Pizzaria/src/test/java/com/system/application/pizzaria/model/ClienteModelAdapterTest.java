package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.*;
import com.system.application.pizzaria.entity.enums.CategoriaPizza;
import com.system.application.pizzaria.entity.enums.StatusPedido;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.database.entity.*;
import com.system.application.pizzaria.external.database.entity.adapter.ClienteModelAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteModelAdapterTest {

    private Cliente clienteToProcess = criaEntidadeCliente();
    private ClienteModel clienteModelToProcess = criaEntidadeClienteModel();


    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws ClienteException {
        //Arrange
        Cliente clienteExpected = criaEntidadeCliente();
        //Act
        Cliente clienteActual = ClienteModelAdapter.modelToEntity(clienteModelToProcess);
        //Assert
        assertEquals(clienteExpected.getEmailCliente(), clienteActual.getEmailCliente());
        assertEquals(clienteExpected.getNome(), clienteActual.getNome());
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModelTest() throws ClienteException {
        //Arrange
        ClienteModel clienteModelExpected = criaEntidadeClienteModel();
        //Act
        ClienteModel clienteModelActual = ClienteModelAdapter.entityToModel(clienteToProcess);
        //Assert
        assertEquals(clienteModelExpected.getNomeModel(), clienteModelActual.getNomeModel());
        assertEquals(clienteModelExpected.getEmailClienteModel(), clienteModelActual.getEmailClienteModel());
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            ClienteModelAdapter.entityToModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToModel Cliente is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            ClienteModelAdapter.modelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter modelToEntity Cliente is Null", e.getMessage());
        }
    }

    public Cliente criaEntidadeCliente() {

        Pedido pedido = new Pedido();
        List<Pizza> listPizza = new ArrayList<>();
        List<Bebida> listBebida = new ArrayList<>();
        List<Ingrediente> listIntediente = new ArrayList<>();
        pedido.setIdPedido(1);
        pedido.setStatusPedido(StatusPedido.AGUARDANDO);
        pedido.setListaPizzaPedido(listPizza);
        pedido.setListaBebidaPedido(listBebida);
        pedido.setPrecoPedido(new BigDecimal("59.00"));
        pedido.setComentarioPedido("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");

        Pizza pizza = new Pizza();
        pizza.setIdPizza(1);
        pizza.setPrecoPizza(new BigDecimal("59.00"));
        pizza.setListaIngredientesPizza(listIntediente);
        pizza.setCategoriaPizza(CategoriaPizza.LIGHT);

        Bebida bebida = new Bebida();
        bebida.setIdBebida(1);
        bebida.setNomeBebida("Sua mãe");
        bebida.setQuantidadeBebida(17);
        bebida.setPrecoBebida(new BigDecimal("59.00"));

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1);
        ingrediente.setPrecoIngrediente(new BigDecimal(3.00));
        ingrediente.setQuantidadeIngrediente(2);
        ingrediente.setNomeIngrediente("Tomate");

        listIntediente.add(ingrediente);
        listPizza.add(pizza);
        listBebida.add(bebida);

        Cliente cliente = new Cliente();
        List<Endereco> listEndereco = new ArrayList<>();
        cliente.setIdCliente(1);
        cliente.setNome("marcio");
        cliente.setCpf("123.456.789-12");
        cliente.setApelido("marcin");
        cliente.setEmailCliente("marcin@gmail.com");
        cliente.setSenha("lasanha");
        cliente.setTelefone("+55 (19) 9 9892-0167");
        cliente.setListaEnderecoCliente(listEndereco);
        cliente.setPedidoCliente(pedido);

        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1);
        endereco.setCepEndereco("13481746");
        endereco.setBairroEndereco("Vitorio Lucato");
        endereco.setCidadeEndereco("Limeria");
        endereco.setRuaEndereco("Luis Mascarim");
        endereco.setComplementoEndereco("casa");


        Endereco endereco2 = new Endereco();
        endereco2.setIdEndereco(2);
        endereco2.setCepEndereco("12345678");
        endereco2.setBairroEndereco("abc");
        endereco2.setCidadeEndereco("limeira");
        endereco2.setRuaEndereco("123");
        endereco2.setComplementoEndereco("ap");


        listEndereco.add(endereco);
        listEndereco.add(endereco2);

        return cliente;
    }

    public ClienteModel criaEntidadeClienteModel() {
        PedidoModel pedidoModel = new PedidoModel();
        List<PizzaModel> listPizzaModel = new ArrayList<>();
        List<BebidaModel> listBebidaModel = new ArrayList<>();
        List<IngredienteModel> listIntedienteModel = new ArrayList<>();
        pedidoModel.setIdPedidoModel(1);
        pedidoModel.setStatusPedidoModel(StatusPedido.AGUARDANDO);
        pedidoModel.setListaPizzaModel(listPizzaModel);
        pedidoModel.setListaBebidaModel(listBebidaModel);
        pedidoModel.setPrecoPedidoModel(new BigDecimal("59.00"));
        pedidoModel.setComentarioPedidoModel("fnfsjngdsnofgjlig, dhufsufhsfgbhsbgf fdhiuashfihasidf.");

        PizzaModel pizzaModel = new PizzaModel();
        pizzaModel.setIdPizzaModel(1);
        pizzaModel.setPrecoPizzaModel(new BigDecimal("59.00"));
        pizzaModel.setListaIngredientesPizzaModelPizzaModel(listIntedienteModel);
        pizzaModel.setCategoriaPizzaModel(CategoriaPizza.LIGHT);

        BebidaModel bebidaModel = new BebidaModel();
        bebidaModel.setIdBebidaModel(1);
        bebidaModel.setNomeBebidaModel("Sua mãe");
        bebidaModel.setQuantidadeBebidaModel(17);
        bebidaModel.setPrecoBebidaModel(new BigDecimal("59.00"));

        IngredienteModel ingrediente = new IngredienteModel();
        ingrediente.setIdIngredienteModel(1);
        ingrediente.setPrecoIngredienteModel(new BigDecimal(3.00));
        ingrediente.setQuantidadeIngredienteModel(2);
        ingrediente.setNomeIngredienteModel("Tomate");


        listIntedienteModel.add(ingrediente);
        listPizzaModel.add(pizzaModel);
        listBebidaModel.add(bebidaModel);
        ClienteModel clienteModel = new ClienteModel();

        List<EnderecoModel> listEnderecoModel = new ArrayList<>();
        clienteModel.setIdClienteModel(1);
        clienteModel.setNomeModel("marcio");
        clienteModel.setCpfModel("123.456.789-12");
        clienteModel.setEmailClienteModel("marcin@gmail.com");
        clienteModel.setApelidoModel("marcin");
        clienteModel.setSenhaModel("lasanha");
        clienteModel.setTelefoneModel("+55 (19) 9 9892-0167");
        clienteModel.setPedidoModelClienteModel(pedidoModel);
        clienteModel.setListaEnderecoModelClienteModel(listEnderecoModel);

        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setIdEndereco(1);
        enderecoModel.setCepEnderecoModel("13481746");
        enderecoModel.setBairroEnderecoModel("Vitorio Lucato");
        enderecoModel.setCidadeEnderecoModel("Limeria");
        enderecoModel.setRuaEnderecoModel("Luis Mascarim");
        enderecoModel.setComplementoEnderecoModel("casa");

        EnderecoModel enderecoModel2 = new EnderecoModel();
        enderecoModel2.setIdEndereco(2);
        enderecoModel2.setCepEnderecoModel("12345678");
        enderecoModel2.setBairroEnderecoModel("abc");
        enderecoModel2.setCidadeEnderecoModel("limeira");
        enderecoModel2.setRuaEnderecoModel("123");
        enderecoModel2.setComplementoEnderecoModel("ap");

        listEnderecoModel.add(enderecoModel);
        listEnderecoModel.add(enderecoModel2);

        return clienteModel;
    }
}
