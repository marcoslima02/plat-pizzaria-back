package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.exception.AtendenteException;

import java.util.List;

public interface AtendentePersistenceDataBase {

    List<Atendente> getAllAtendentes();
    Atendente getAtendenteById(Integer idAtendente) throws AtendenteException;
    Atendente getAtendenteByCPF(String cpfAtendente);
}
