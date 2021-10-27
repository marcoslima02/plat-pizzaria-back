package com.system.application.pizzaria.usecase.atendente;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.external.AtendentePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaveAtendente {

    @Autowired
    private AtendentePersistenceDataBase atendentePersistenceDataBase;

    @Autowired
    private ValidateAtendenteByCPF validateAtendenteByCPF;

    public Atendente saveAtendente(Atendente atendente) throws AtendenteException {
        if(!validateAtendenteByCPF.getValidationAtendenteCPF(atendente.getCpf())){
            return atendentePersistenceDataBase.saveAtendente(atendente);
        }
        else {
            throw new AtendenteException(ErrorType.DATA_DUPLICATE, String.format("Funcionario ja existente com o CPF: %s", atendente.getCpf()), new Date(), HttpStatus.BAD_REQUEST);
        }
    }
}
