package com.system.application.pizzaria.external;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.exception.AtendenteException;

import java.util.List;

public interface AtendentePersistenceDataBase {

    List<Atendente> getAllAtendentes() throws AtendenteException;

    Atendente getAtendenteById(Integer idAtendente) throws AtendenteException;

    Atendente saveAtendente(Atendente atendente) throws AtendenteException;

    Boolean validateAtendenteByCPF(String cpfAtendente)throws AtendenteException;

    Atendente getAtendenteByCPF(String cpfAtendente) throws AtendenteException;
}
