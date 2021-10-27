package com.system.application.pizzaria.usecase.atendente;

import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.external.AtendentePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateAtendenteByCPF {

    @Autowired
    private AtendentePersistenceDataBase atendentePersistenceDataBase;

    public Boolean getValidationAtendenteCPF(String cpfAtendente) throws AtendenteException {
        return atendentePersistenceDataBase.validateAtendenteByCPF(cpfAtendente);
    }

}
