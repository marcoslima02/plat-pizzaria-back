package com.system.application.pizzaria.usecase.cliente;

import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.external.ClientePersistenceDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateClienteByCPF {

    @Autowired
    private ClientePersistenceDataBase clientePersistenceDataBase;

    public Boolean getValidationClienteByCPF(String cpfCliente) throws ClienteException {
        return clientePersistenceDataBase.getvalidateCPF(cpfCliente);
    }
}
