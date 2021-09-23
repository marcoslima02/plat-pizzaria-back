package com.system.application.pizzaria.model;


import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.external.database.entity.AtendenteModel;
import com.system.application.pizzaria.external.database.entity.adapter.AtendenteModelAdapter;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class AtendenteModelAdapterTest {

    @Test
    public void shouldAdapterCorrectlyModelToEntityTest() throws AtendenteException {
        //Arrange
        Atendente atendenteExpected = criaEntidadeAtendente();
        AtendenteModel atendenteModel = criaEntidadeAtendenteModel();
        //Act
        Atendente atendenteActual = AtendenteModelAdapter.modelToEntity(atendenteModel);
        //Assert
        assertEquals(atendenteExpected, atendenteActual);

    }

    @Test
    public void shouldAdapterCorrectlyEntityToModelTest() throws AtendenteException {
        //Arrange
        AtendenteModel atendenteExpected = criaEntidadeAtendenteModel();
        Atendente atendenteEntity = criaEntidadeAtendente();
        //Act
        AtendenteModel atendenteActual = AtendenteModelAdapter.entityToModel(atendenteEntity);
        //Assert
        assertEquals(atendenteExpected, atendenteActual);
    }

    @Test
    public void shouldExceptionWithModelNullTest() {
        //Act
        try {
            AtendenteModelAdapter.modelToEntity(null);
        } catch (Exception e) {
            //Assert
            assertEquals("Adapter modelToEntity Atendente is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithEntityNullTest() {
        //Act
        try {
            AtendenteModelAdapter.entityToModel(null);
        } catch (Exception e) {
            //Assert
            assertEquals("Adapter entityToModel Atendente is Null", e.getMessage());
        }
    }

    public Atendente criaEntidadeAtendente() {
        Atendente atendente = new Atendente();
        atendente.setIdAtendente(9);
        atendente.setNome("Sarina Briones");
        atendente.setCpf("123.456.789.-12");
        atendente.setApelido("Sarinita");
        atendente.setSenha("sari@123;");
        atendente.setTelefone("+55 (12) 9 9701-4672");
        atendente.setHorarioTrabalho(LocalDateTime.of(2000, 05, 20, 23, 40));
        atendente.setSalario(new BigDecimal("5000"));

        return atendente;
    }

    public AtendenteModel criaEntidadeAtendenteModel() {
        AtendenteModel atendenteModel = new AtendenteModel();
        atendenteModel.setIdAtendenteModel(9);
        atendenteModel.setNome("Sarina Briones");
        atendenteModel.setCpf("123.456.789.-12");
        atendenteModel.setApelido("Sarinita");
        atendenteModel.setSenha("sari@123;");
        atendenteModel.setTelefone("+55 (12) 9 9701-4672");
        atendenteModel.setHorarioTrabalho(LocalDateTime.of(2000, 05, 20, 23, 40));
        atendenteModel.setSalario(new BigDecimal("5000"));

        return atendenteModel;
    }
}
