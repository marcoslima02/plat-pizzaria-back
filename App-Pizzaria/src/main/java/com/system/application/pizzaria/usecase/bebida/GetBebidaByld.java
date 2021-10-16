package com.system.application.pizzaria.usecase.bebida;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.external.BebidaPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetBebidaByld {

    @Autowired
    private BebidaPersistenceDataBase bebidaPersistenceDataBase;

    public Bebida getBebidaById(Integer idBebida) throws BebidaException {
        return bebidaPersistenceDataBase.getBebidaById(idBebida);
    }
}

