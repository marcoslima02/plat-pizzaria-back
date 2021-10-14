package com.system.application.pizzaria.usecase.cliente;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.ClientePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateClienteLogin {

    @Autowired
    private ClientePersistenceDataBase clientePersistenceDataBase;

    public Cliente validateClienteLogin(String cpfCliente, String senhaCliente) throws ClienteException {
       return clientePersistenceDataBase.getValidateClienteLogin(cpfCliente, senhaCliente);
    }
}
