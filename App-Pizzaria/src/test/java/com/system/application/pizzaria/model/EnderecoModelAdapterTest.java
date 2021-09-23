package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Endereco;
import com.system.application.pizzaria.exception.EnderecoException;
import com.system.application.pizzaria.external.database.entity.EnderecoModel;
import com.system.application.pizzaria.external.database.entity.adapter.EnderecoModelAdapter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnderecoModelAdapterTest {

    private Endereco enderecoToProcess = criaEntidadeEndereco();
    private EnderecoModel enderecoModelToProcess = criaEntidadeEnderecoModel();


    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws EnderecoException {
        //Arrange
        Endereco enderecoExpected = criaEntidadeEndereco();
        //Act
        Endereco enderecoActual = EnderecoModelAdapter.modelToEntity(enderecoModelToProcess);
        //Assert
        assertEquals(enderecoExpected, enderecoActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModel() throws EnderecoException {
        //Arrange
        EnderecoModel enderecoModelExpected = criaEntidadeEnderecoModel();
        //Act
        EnderecoModel enderecoModelActual = EnderecoModelAdapter.entityToModel(enderecoToProcess);
        //Assert
        assertEquals(enderecoModelExpected, enderecoModelActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            EnderecoModelAdapter.entityToModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToModel Endereco is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            EnderecoModelAdapter.modelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter modelToEntity Endereco is Null", e.getMessage());
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

    public EnderecoModel criaEntidadeEnderecoModel() {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setIdEndereco(1);
        enderecoModel.setCepEnderecoModel("13587-209");
        enderecoModel.setRuaEnderecoModel("Rua zornof de linsdoa");
        enderecoModel.setCidadeEnderecoModel("Limeira");
        enderecoModel.setNumeroEnderecoModel(387);
        enderecoModel.setBairroEnderecoModel("Jardim Pedras Preciosas");
        enderecoModel.setComplementoEnderecoModel("Perto da UNIP");
        return enderecoModel;
    }
}
