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
    public List<Atendente> getAllAtendentes() {
        List<AtendenteModel> atendenteModelList = atendenteRepository.findAll();
        return AtendenteModelAdapter.modelListToEntityList(atendenteModelList);
    }

    @Override
    public Atendente getAtendenteById(Integer idAtendente) throws AtendenteException {
        try {
            AtendenteModel atendenteModel = atendenteRepository.getById(idAtendente);
            return AtendenteModelAdapter.modelToEntity(atendenteModel);
        }catch (Exception e){
            throw new AtendenteException(ErrorType.DATA_BASE_NOT_FOUND, String.format("DATABASE atendente NOT FOUND FOR ID: %d", idAtendente),new Date() , HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Atendente getAtendenteByCPF(String cpfAtendente) {
        return null;
    }
}
