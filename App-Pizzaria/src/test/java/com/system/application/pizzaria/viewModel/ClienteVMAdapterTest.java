package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.database.entity.ClienteModel;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.viewmodel.ClienteVM;
import com.system.application.pizzaria.viewmodel.EnderecoVM;
import com.system.application.pizzaria.viewmodel.adapter.ClienteVMAdapter;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteVMAdapterTest {

    private Cliente clienteToProcess = criaEntidadeCliente();
    private ClienteVM clienteVMToProcess = criaEntidadeClienteVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws ClienteException {
        //Arrange
        Cliente clienteExpected = criaEntidadeCliente();
        //Act
        Cliente clienteActual = ClienteVMAdapter.viewModelToEntity(clienteVMToProcess);
        //Assert
        assertEquals(clienteExpected, clienteActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() throws ClienteException {
        //Arrange
        ClienteVM clienteVMExpected = criaEntidadeClienteVM();
        //Act
        ClienteVM clienteVMActual = ClienteVMAdapter.entityToViewModel(clienteToProcess);
        //Assert
        assertEquals(clienteVMExpected, clienteVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            ClienteVMAdapter.entityToViewModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToViewModel Cliente is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            ClienteVMAdapter.viewModelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter viewModelToEntity Cliente is Null", e.getMessage());
        }
    }

    public Cliente criaEntidadeCliente() {
        Cliente cliente = new Cliente();
        List<Endereco> listEndereco = new ArrayList<>();
        cliente.setIdCliente(1);
        cliente.setNome("marcio");
        cliente.setCpf("123.456.789-12");
        cliente.setApelido("marcin");
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

    public ClienteVM criaEntidadeClienteVM() {
        ClienteVM clienteVM = new ClienteVM();
        List<EnderecoVM> listEnderecoVM = new ArrayList<>();
        clienteVM.setIdClienteVM(1);
        clienteVM.setNomeVM("marcio");
        clienteVM.setCpfVM("123.456.789-12");
        clienteVM.setApelidoVM("marcin");
        clienteVM.setSenhaVM("lasanha");
        clienteVM.setTelefoneVM("+55 (19) 9 9892-0167");
        clienteVM.setListaEnderecoVMClienteVM(listEnderecoVM);

        EnderecoVM enderecoVM = new EnderecoVM();
        enderecoVM.setIdEnderecoVM(1);
        enderecoVM.setCepEnderecoVM("13481746");
        enderecoVM.setBairroEnderecoVM("Vitorio Lucato");
        enderecoVM.setCidadeEnderecoVM("Limeria");
        enderecoVM.setRuaEnderecoVM("Luis Mascarim");
        enderecoVM.setComplementoEnderecoVM("casa");

        EnderecoVM enderecoVM2 = new EnderecoVM();
        enderecoVM2.setIdEnderecoVM(2);
        enderecoVM2.setCepEnderecoVM("12345678");
        enderecoVM2.setBairroEnderecoVM("abc");
        enderecoVM2.setCidadeEnderecoVM("limeira");
        enderecoVM2.setRuaEnderecoVM("123");
        enderecoVM2.setComplementoEnderecoVM("ap");

        listEnderecoVM.add(enderecoVM);
        listEnderecoVM.add(enderecoVM2);

        return clienteVM;
    }
}
