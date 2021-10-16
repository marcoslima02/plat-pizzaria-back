package com.system.application.pizzaria.usecase.bebida;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.external.BebidaPersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllBebida {

    @Autowired
    private BebidaPersistenceDataBase bebidaPersistenceDataBase;

    public List<Bebida> getAllBebidas(){
        return bebidaPersistenceDataBase.getAllBebidas();
    }
}

