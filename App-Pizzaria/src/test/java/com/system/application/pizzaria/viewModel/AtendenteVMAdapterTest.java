package com.system.application.pizzaria.viewModel;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.viewmodel.AtendenteVM;
import com.system.application.pizzaria.viewmodel.adapter.AtendenteVMAdapter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtendenteVMAdapterTest {

    private Atendente atendenteToProcess = criaEntidadeAtendente();
    private AtendenteVM atendenteVMToProcess = criaEntidadeAtendenteVM();

    @Test
    public void shouldAdapterCorrectlyEntityToViewModelTest() throws AtendenteException {
        //Arrange
        AtendenteVM atendenteExpected = criaEntidadeAtendenteVM();
        //Act
        AtendenteVM atendenteActual= AtendenteVMAdapter.entityToViewModel(atendenteToProcess);
        //Assert
        assertEquals(atendenteExpected, atendenteActual);
    }

    @Test
    public void shouldAdapterCorrectlyViewModelToEntityTest() throws AtendenteException {
        //Arrange
        Atendente atendenteExpected = criaEntidadeAtendente();
        //Act
        Atendente atendenteActual = AtendenteVMAdapter.viewModelToEntity(atendenteVMToProcess);
        //Assert
        assertEquals(atendenteExpected,atendenteActual);
    }

    @Test
    public void shouldExceptionWithEntityNullTest(){
        //Act
        try {
            AtendenteVMAdapter.entityToViewModel(null);
        }catch (Exception e){
            assertEquals("Adapter entityToViewModel Atendente is Null", e.getMessage());
        }
    }

    @Test
    public void shouldExceptionWithViewModelNullTest(){
        //Act
        try {
            AtendenteVMAdapter.viewModelToEntity(null);
        }catch (Exception e){
            assertEquals("Adapter viewModelToEntity Atendente is Null", e.getMessage());
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

    public AtendenteVM criaEntidadeAtendenteVM(){
        AtendenteVM atendenteVM = new AtendenteVM();
        atendenteVM.setIdAtendenteVM(9);
        atendenteVM.setNomeVM("Sarina Briones");
        atendenteVM.setCpfVM("123.456.789.-12");
        atendenteVM.setApelidoVM("Sarinita");
        atendenteVM.setSenhaVM("sari@123;");
        atendenteVM.setTelefoneVM("+55 (12) 9 9701-4672");
        atendenteVM.setHorarioTrabalhoVM(LocalDateTime.of(2000, 05, 20, 23, 40));
        atendenteVM.setSalarioVM(new BigDecimal("5000"));

        return atendenteVM;
    }
}
