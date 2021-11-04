package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.exception.PagamentoException;
import com.system.application.pizzaria.external.database.entity.PagamentoModel;
import com.system.application.pizzaria.external.database.entity.adapter.PagamentoModelAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagamentoModelAdapterTest {

    private Pagamento pagamentoToProcess = criaEntidadePagamento();
    private PagamentoModel pagamentoModelToProcess = criaEntidadePagamentoModel();


    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws PagamentoException {
        //Arrange
        Pagamento pagamentoExpected = criaEntidadePagamento();
        //Act
        Pagamento pagamentoActual = PagamentoModelAdapter.modelToEntity(pagamentoModelToProcess);
        //Assert
        assertEquals(pagamentoExpected, pagamentoActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModel() throws PagamentoException {
        //Arrange
        PagamentoModel pagamentoModelExpected = criaEntidadePagamentoModel();
        //Act
        PagamentoModel pagamentoModelActual = PagamentoModelAdapter.entityToModel(pagamentoToProcess);
        //Assert
        assertEquals(pagamentoModelExpected, pagamentoModelActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            PagamentoModelAdapter.entityToModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToModel Pagamento is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            PagamentoModelAdapter.modelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter modelToEntity Pagamento is Null", e.getMessage());
        }
    }

    public Pagamento criaEntidadePagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(1);
        pagamento.setFuncionarioPagamento("Calabresa");
        pagamento.setSalarioPagamento(new BigDecimal(3.99));

        return pagamento;
    }

    public PagamentoModel criaEntidadePagamentoModel() {
        PagamentoModel pagamentoModel = new PagamentoModel();
        pagamentoModel.setIdPagamentoModel(1);
        pagamentoModel.setFuncionarioPagamentoModel("Calabresa");
        pagamentoModel.setSalarioPagamentoModel(new BigDecimal(3.99));

        return pagamentoModel;
    }

}
