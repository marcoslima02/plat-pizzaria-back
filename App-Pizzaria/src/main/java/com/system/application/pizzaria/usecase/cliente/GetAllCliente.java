package com.system.application.pizzaria.usecase.cliente;

import com.system.application.pizzaria.entity.Cliente;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.ClientePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCliente {

    @Autowired
    private ClientePersistenceDataBase clientePersistenceDataBase;

    public List<Cliente> getAllClientes() throws ClienteException {
        return clientePersistenceDataBase.getAllClientes();
    }
}
