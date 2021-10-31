package com.system.application.pizzaria.external.database;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.external.AtendentePersistenceDataBase;
import com.system.application.pizzaria.external.database.entity.AtendenteModel;
import com.system.application.pizzaria.external.database.entity.adapter.AtendenteModelAdapter;
import com.system.application.pizzaria.external.database.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AtendentePersistenceDataBaseImpl implements AtendentePersistenceDataBase {

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Override
    public List<Atendente> getAllAtendentes() throws AtendenteException {
        try{
            List<AtendenteModel> atendenteModelList = atendenteRepository.findAll();
            return AtendenteModelAdapter.modelListToEntityList(atendenteModelList);
        }catch (Exception e){
            throw new AtendenteException(ErrorType.DATA_BASE_NOT_FOUND, "Erro ao trazer todos Atendentes", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Atendente getAtendenteById(Integer idAtendente) throws AtendenteException {
        try {
            AtendenteModel atendenteModel = atendenteRepository.getById(idAtendente);
            return AtendenteModelAdapter.modelToEntity(atendenteModel);
        } catch (Exception e) {
            throw new AtendenteException(ErrorType.DATA_BASE_NOT_FOUND, String.format("DATABASE atendente NOT FOUND FOR ID: %d", idAtendente), new Date(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Atendente saveAtendente(Atendente atendente) throws AtendenteException {
        AtendenteModel atendenteModel = AtendenteModelAdapter.entityToModel(atendente);
        try {
            atendenteRepository.save(atendenteModel);
            return AtendenteModelAdapter.modelToEntity(atendenteModel);
        } catch (Exception e) {
            throw new AtendenteException(ErrorType.ERROR_DATABASE_SAVE, "Erro ao salvar Atendente no Banco de Dados", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean validateAtendenteByCPF(String cpfAtendente) throws AtendenteException {
        return atendenteRepository.existsByCpfModel(cpfAtendente);
    }

    @Override
    public Atendente getAtendenteByCPF(String cpfAtendente) {
        return null;
    }
}
