package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Administrador;
import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.exception.AdministradorException;
import com.system.application.pizzaria.viewmodel.AdministradorVM;
import com.system.application.pizzaria.viewmodel.PagamentoVM;
import com.system.application.pizzaria.viewmodel.adapter.AdministradorVMAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdministradorVMAdapterTest {

    private AdministradorVM administradorVM = criaEntidadeAdministradorVM();
    private Administrador administrador = criaEntidadeAdministrador();

    @Test
    public void shouldAdapterCorrectlyViewModelToEntityTest() throws AdministradorException {
        //Arrange
        Administrador cozinheiroExpected = criaEntidadeAdministrador();
        //Act
        Administrador cozinheiroActual = AdministradorVMAdapter.viewModelToEntity(administradorVM);
        //Assert
        assertEquals(cozinheiroExpected, cozinheiroActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToViewModel() throws AdministradorException {
        //Arrange
        AdministradorVM cozinheiroVMExpected = criaEntidadeAdministradorVM();
        //Act
        AdministradorVM cozinheiroVMActual = AdministradorVMAdapter.entityToViewModel(administrador);
        //Assert
        Assertions.assertEquals(cozinheiroVMExpected, cozinheiroVMActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            AdministradorVMAdapter.entityToViewModel(null);
        } catch (AdministradorException e) {
            Assertions.assertEquals("Adapter entityToViewModel Administrador is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithViewModelNullTest() {
        //Act
        try {
            AdministradorVMAdapter.viewModelToEntity(null);
        } catch (AdministradorException e) {
            Assertions.assertEquals("Adapter viewModelToEntity Administrador is Null", e.getMessage());
        }
    }

    private Administrador criaEntidadeAdministrador() {
        Administrador administrador = new Administrador();
        List<Pagamento> listPagamento = new ArrayList<>();
        administrador.setIdAdministrador(1);
        administrador.setNome("Bolacha");
        administrador.setCpf("431.654.989-60");
        administrador.setApelido("Leo");
        administrador.setSenha("leo123");
        administrador.setTelefone("3219370234");
        administrador.setSalario(new BigDecimal(6000.00));
        administrador.setListaPagamentoAdministrador(listPagamento);

        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamento(1);
        pagamento.setFuncionarioPagamento("Calabresa");
        pagamento.setSalarioPagamento(new BigDecimal(3.99));

        listPagamento.add(pagamento);
        return administrador;
    }

    private AdministradorVM criaEntidadeAdministradorVM() {
        AdministradorVM administradorVM = new AdministradorVM();
        List<PagamentoVM> listPagamentoVM = new ArrayList<>();
        administradorVM.setIdAdministradorVM(1);
        administradorVM.setNomeVM("Bolacha");
        administradorVM.setCpfVM("431.654.989-60");
        administradorVM.setApelidoVM("Leo");
        administradorVM.setSenhaVM("leo123");
        administradorVM.setTelefoneVM("3219370234");
        administradorVM.setSalarioVM(new BigDecimal(6000.00));
        administradorVM.setListaPagamentoVMAdministradorVM(listPagamentoVM);

        PagamentoVM pagamentoVM = new PagamentoVM();
        pagamentoVM.setIdPagamentoVM(1);
        pagamentoVM.setFuncionarioPagamentoVM("Calabresa");
        pagamentoVM.setSalarioPagamentoVM(new BigDecimal(3.99));

        listPagamentoVM.add(pagamentoVM);
        return administradorVM;
    }
}
