package com.system.application.pizzaria.viewmodel.adapter.forms;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.cadastro.AtendenteCadastroVM;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class AtendenteCadastroVMAdapter {


    public static Atendente viewModelToEntity(AtendenteCadastroVM atendenteCadastroVM) throws AtendenteException {
        Atendente atendente = new Atendente();
        try {
            atendente.setNome(atendenteCadastroVM.getNomeVM());
            atendente.setCpf(atendenteCadastroVM.getCpfVM());
            atendente.setApelido(atendenteCadastroVM.getApelidoVM());
            atendente.setSenha(atendenteCadastroVM.getSenhaVM());
            atendente.setTelefone(atendenteCadastroVM.getTelefoneVM());
            atendente.setSalario(new BigDecimal(0.00));
            atendente.setHorarioTrabalho(LocalDateTime.now());
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteCadastroVM para Atendente");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return atendente;
    }

    public static AtendenteCadastroVM entityToViewModel(Atendente atendente) throws AtendenteException {
        AtendenteCadastroVM atendenteCadastroVM = new AtendenteCadastroVM();
        try {
            atendenteCadastroVM.setNomeVM(atendente.getNome());
            atendenteCadastroVM.setCpfVM(atendente.getCpf());
            atendenteCadastroVM.setApelidoVM(atendente.getApelido());
            atendenteCadastroVM.setSenhaVM(atendente.getSenha());
            atendenteCadastroVM.setTelefoneVM(atendente.getTelefone());
            atendenteCadastroVM.setApelidoVM(atendente.getApelido());
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Atendente para AtendenteCadastroVM");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return atendenteCadastroVM;
    }
}
