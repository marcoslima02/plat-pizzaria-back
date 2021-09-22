package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.viewmodel.EnderecoVM;
import com.system.application.pizzaria.viewmodel.adapter.EnderecoVMAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoVMAdapterTest {

    private Endereco enderecoToProcess = criaEntidadeEndereco();
    private EnderecoVM enderecoVMToProcess = criaEntidadeEnderecoVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() {
        //Arrange
        Endereco enderecoExpected = criaEntidadeEndereco();
        //Act
        Endereco enderecoActual = EnderecoVMAdapter.viewModelToEntity(enderecoVMToProcess);
        //Assert
        assertEquals(enderecoExpected, enderecoActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToVM() {
        //Arrange
        EnderecoVM enderecoVMExpected = criaEntidadeEnderecoVM();
        //Act
        EnderecoVM enderecoVMActual = EnderecoVMAdapter.entityToViewModel(enderecoToProcess);
        //Assert
        assertEquals(enderecoVMExpected, enderecoVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            EnderecoVMAdapter.entityToViewModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToVM Endereco is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            EnderecoVMAdapter.viewModelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter VMToEntity Endereco is Null", e.getMessage());
        }
    }

    public Endereco criaEntidadeEndereco() {
        Endereco endereco = new Endereco();
        endereco.setIdEndereco(1);
        endereco.setCepEndereco("13587-209");
        endereco.setRuaEndereco("Rua zornof de linsdoa");
        endereco.setCidadeEndereco("Limeira");
        endereco.setNumeroEndereco(387);
        endereco.setBairroEndereco("Jardim Pedras Preciosas");
        endereco.setComplementoEndereco("Perto da UNIP");
        return endereco;
    }

    public EnderecoVM criaEntidadeEnderecoVM() {
        EnderecoVM enderecoVM = new EnderecoVM();
        enderecoVM.setIdEnderecoVM(1);
        enderecoVM.setCepEnderecoVM("13587-209");
        enderecoVM.setRuaEnderecoVM("Rua zornof de linsdoa");
        enderecoVM.setCidadeEnderecoVM("Limeira");
        enderecoVM.setNumeroEnderecoVM(387);
        enderecoVM.setBairroEnderecoVM("Jardim Pedras Preciosas");
        enderecoVM.setComplementoEnderecoVM("Perto da UNIP");
        return enderecoVM;
    }
}
