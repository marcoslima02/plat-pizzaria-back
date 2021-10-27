package com.system.application.pizzaria.usecase.atendente;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.external.AtendentePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveAtendente {

    @Autowired
    private AtendentePersistenceDataBase atendentePersistenceDataBase;

    public Atendente saveAtendente(Atendente atendente) throws AtendenteException {
        return atendentePersistenceDataBase.saveAtendente(atendente);
    }
}
