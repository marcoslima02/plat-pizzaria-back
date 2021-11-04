package com.system.application.pizzaria.model;

import com.system.application.pizzaria.entity.Administrador;
import com.system.application.pizzaria.entity.Pagamento;
import com.system.application.pizzaria.exception.AdministradorException;
import com.system.application.pizzaria.external.database.entity.*;
import com.system.application.pizzaria.external.database.entity.adapter.AdministradorModelAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdministradorModelAdapterTest {
    private AdministradorModel administradorModel = criaEntidadeAdministradorModel();
    private Administrador administrador = criaEntidadeAdministrador();

    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws AdministradorException {
        //Arrange
        Administrador cozinheiroExpected = criaEntidadeAdministrador();
        //Act
        Administrador cozinheiroActual = AdministradorModelAdapter.modelToEntity(administradorModel);
        //Assert
        assertEquals(cozinheiroExpected, cozinheiroActual);
    }

    @Test
    public void shouldAdapterCorrectlyEntityToModel() throws AdministradorException {
        //Arrange
        AdministradorModel cozinheiroModelExpected = criaEntidadeAdministradorModel();
        //Act
        AdministradorModel cozinheiroModelActual = AdministradorModelAdapter.entityToModel(administrador);
        //Assert
        Assertions.assertEquals(cozinheiroModelExpected, cozinheiroModelActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            AdministradorModelAdapter.entityToModel(null);
        } catch (AdministradorException e) {
            Assertions.assertEquals("Adapter entityToModel Administrador is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            AdministradorModelAdapter.modelToEntity(null);
        } catch (AdministradorException e) {
            Assertions.assertEquals("Adapter modelToEntity Administrador is Null", e.getMessage());
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

    private AdministradorModel criaEntidadeAdministradorModel() {
        AdministradorModel administradorModel = new AdministradorModel();
        List<PagamentoModel> listPagamentoModel = new ArrayList<>();
        administradorModel.setIdAdministradorModel(1);
        administradorModel.setNomeModel("Bolacha");
        administradorModel.setCpfModel("431.654.989-60");
        administradorModel.setApelidoModel("Leo");
        administradorModel.setSenhaModel("leo123");
        administradorModel.setTelefoneModel("3219370234");
        administradorModel.setSalarioModel(new BigDecimal(6000.00));
        administradorModel.setListaPagamentoModelAdministradorModel(listPagamentoModel);

        PagamentoModel pagamentoModel = new PagamentoModel();
        pagamentoModel.setIdPagamentoModel(1);
        pagamentoModel.setFuncionarioPagamentoModel("Calabresa");
        pagamentoModel.setSalarioPagamentoModel(new BigDecimal(3.99));

        listPagamentoModel.add(pagamentoModel);
        return administradorModel;
    }
}
