package com.system.application.pizzaria.usecase.cliente;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.ClientePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaveCliente {

    @Autowired
    private ClientePersistenceDataBase clientePersistenceDataBase;

    @Autowired
    private ValidateClienteByCPF validateClienteByCPF;

    public Cliente saveCliente(Cliente cliente) throws ClienteException {
        if (!validateClienteByCPF.getValidationClienteByCPF(cliente.getCpf())) {
            return clientePersistenceDataBase.saveCliente(cliente);
        } else {
            throw new ClienteException(ErrorType.DATA_DUPLICATE, "CPF Ja existente", new Date(), HttpStatus.BAD_REQUEST);
        }
    }
}
