package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.exception.BebidaException;

import java.util.List;

public interface BebidaPersistenceDataBase {

    List<Bebida> getAllBebidas();

    Bebida getBebidaById(Integer idBebida) throws BebidaException;

}
