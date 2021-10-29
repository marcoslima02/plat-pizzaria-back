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

        @Autowired
        private ValidateBebidaPreco validateBebidaPreco;

        public Bebida saveBebida(Bebida bebida) throws BebidaException {
            if(validateBebidaPreco.isBebidaValorCorrect(bebida)){
                return bebidaPersistenceDataBase.saveBebida(bebida);
            }
            throw new BebidaException(ErrorType.ERRO_TOTAL_PRICE_PEDIDO, "Preço da Bebida esta errado", new Date(), HttpStatus.BAD_REQUEST);
        }
    }
