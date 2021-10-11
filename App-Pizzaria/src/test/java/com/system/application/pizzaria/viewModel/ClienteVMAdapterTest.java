package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.viewmodel.ClienteVM;
import com.system.application.pizzaria.viewmodel.adapter.ClienteVMAdapter;
import org.junit.jupiter.api.Test;

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
            assertEquals("Adapter entityToVM Cliente is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            ClienteVMAdapter.viewModelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter VMToEntity Cliente is Null", e.getMessage());
        }
    }

    public Cliente criaEntidadeCliente() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNome("Marcio");
        cliente.setCpf("123.456.789.12");
        cliente.setApelido("Marcin");
        cliente.setSenha("lasanha");
        cliente.setTelefone("+55 (19) 9 9892-0167");

        return cliente;
    }

    public ClienteVM criaEntidadeClienteVM() {
        ClienteVM clienteVM = new ClienteVM();
        clienteVM.setIdClienteVM(1);
        clienteVM.setNomeVM("Marcio");
        clienteVM.setCpfVM("123.456.789.12");
        clienteVM.setApelidoVM("Marcin");
        clienteVM.setSenhaVM("lasanha");
        clienteVM.setTelefoneVM("+55 (19) 9 9892-0167");

        return clienteVM;
    }
}
