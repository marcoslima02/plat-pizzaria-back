package com.system.application.pizzaria.usecase.atendente;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.external.AtendentePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAtendente {

    @Autowired
    private AtendentePersistenceDataBase atendentePersistenceDataBase;

    public List<Atendente> getAllAtendentes(){
        return atendentePersistenceDataBase.getAllAtendentes();
    }
}
