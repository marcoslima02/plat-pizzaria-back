package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.exception.IngredienteException;

import java.math.BigDecimal;
import java.util.List;

public interface BebidaPersistenceDataBase {

    List<Bebida> getAllBebidas();

    Bebida getBebidaById(Integer idBebida) throws BebidaException;
    Bebida saveBebida(Bebida bebida) throws BebidaException;
    Boolean validateBebidaPreco(BigDecimal precoBebida)throws BebidaException;


}
