package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.exception.PagamentoException;
import com.system.application.pizzaria.viewmodel.PagamentoVM;
import com.system.application.pizzaria.viewmodel.adapter.PagamentoVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagamentoVMAdapterTest {


    private Pagamento pagamentoToProcess = criaEntidadePagamento();
    private PagamentoVM pagamentoVMToProcess = criaEntidadePagamentoVM();


    @Test
    public void shouldAdapterCorrectlyVMToEntityTest() throws PagamentoException {
        //Arrange
        Pagamento pagamentoExpected = criaEntidadePagamento();
        //Act
        Pagamento pagamentoActual = PagamentoVMAdapter.viewModelToEntity(pagamentoVMToProcess);
        //Assert
        assertEquals(pagamentoExpected, pagamentoActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToViewModel() throws PagamentoException {
        //Arrange
        PagamentoVM pagamentoVMExpected = criaEntidadePagamentoVM();
        //Act
        PagamentoVM pagamentoVMActual = PagamentoVMAdapter.entityToViewModel(pagamentoToProcess);
        //Assert
        assertEquals(pagamentoVMExpected, pagamentoVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            PagamentoVMAdapter.entityToViewModel(null);
        } catch (Exception e) {
            assertEquals("Adapter entityToViewModel Pagamento is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithViewModelNullTest() {
        //Act
        try {
            PagamentoVMAdapter.viewModelToEntity(null);
        } catch (Exception e) {
            assertEquals("Adapter viewModelToEntity Pagamento is Null", e.getMessage());
        }
    }

    public Pagamento criaEntidadePagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(1);
        pagamento.setFuncionarioPagamento("Calabresa");
        pagamento.setSalarioPagamento(new BigDecimal(3.99));

        return pagamento;
    }

    public PagamentoVM criaEntidadePagamentoVM() {
        PagamentoVM pagamentoVM = new PagamentoVM();
        pagamentoVM.setIdPagamentoVM(1);
        pagamentoVM.setFuncionarioPagamentoVM("Calabresa");
        pagamentoVM.setSalarioPagamentoVM(new BigDecimal(3.99));

        return pagamentoVM;
    }

}
