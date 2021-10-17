package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.database.entity.ClienteModel;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.external.database.entity.adapter.ClienteModelAdapter;
import org.junit.jupiter.api.Test;

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
        assertEquals(clienteExpected, clienteActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModel() throws ClienteException {
        //Arrange
        ClienteModel clienteModelExpected = criaEntidadeClienteModel();
        //Act
        ClienteModel clienteModelActual = ClienteModelAdapter.entityToModel(clienteToProcess);
        //Assert
        assertEquals(clienteModelExpected, clienteModelActual);
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
        ClienteModel clienteModel = new ClienteModel();
        List<EnderecoModel> listEnderecoModel = new ArrayList<>();
        clienteModel.setIdClienteModel(1);
        clienteModel.setNomeModel("marcio");
        clienteModel.setCpfModel("123.456.789-12");
        clienteModel.setEmailClienteModel("marcin@gmail.com");
        clienteModel.setApelidoModel("marcin");
        clienteModel.setSenhaModel("lasanha");
        clienteModel.setTelefoneModel("+55 (19) 9 9892-0167");
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
