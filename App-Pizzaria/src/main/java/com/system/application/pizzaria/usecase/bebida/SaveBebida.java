package com.system.application.pizzaria.usecase.bebida;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.external.BebidaPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaveBebida {

    @Autowired
    private BebidaPersistenceDataBase bebidaPersistenceDataBase;

    public Bebida saveBebida(Bebida bebida) throws BebidaException {
        return bebidaPersistenceDataBase.saveBebida(bebida);
    }
}
