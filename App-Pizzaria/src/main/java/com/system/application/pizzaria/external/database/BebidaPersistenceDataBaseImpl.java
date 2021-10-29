package com.system.application.pizzaria.external.database;

import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.external.BebidaPersistenceDataBase;
import com.system.application.pizzaria.external.database.entity.BebidaModel;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.external.database.entity.adapter.BebidaCadastroModelAdapter;
import com.system.application.pizzaria.external.database.entity.adapter.BebidaModelAdapter;
import com.system.application.pizzaria.external.database.entity.adapter.IngredienteCadastroModelAdapter;
import com.system.application.pizzaria.external.database.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
public class BebidaPersistenceDataBaseImpl implements BebidaPersistenceDataBase {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Override
    public List<Bebida> getAllBebidas() {
        List<BebidaModel> bebidaModelList = bebidaRepository.findAll();
        return BebidaModelAdapter.modelListToEntityList(bebidaModelList);
    }

    @Override
    public Bebida getBebidaById(Integer idBebida) throws BebidaException {
        try {
            BebidaModel bebidaModel = bebidaRepository.getById(idBebida);
            return BebidaModelAdapter.modelToEntity(bebidaModel);
        }catch (Exception e){
            throw new BebidaException(ErrorType.DATA_BASE_NOT_FOUND, String.format("DATABASE bebida NOT FOUND FOR ID: %d", idBebida),new Date() , HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Bebida saveBebida(Bebida bebida) throws BebidaException {
        BebidaModel bebidaModel = BebidaCadastroModelAdapter.entityToModel(bebida);
        try {
            bebidaRepository.save(bebidaModel);
            return BebidaCadastroModelAdapter.modelToEntity(bebidaModel);
        } catch (Exception e) {
            throw new BebidaException(ErrorType.ERROR_DATABASE_SAVE, "Erro ao salvar Bebida", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Boolean validateBebidaPreco(BigDecimal precoBebida) throws BebidaException {
        return null;
    }
}

