package com.system.application.pizzaria.external.database;

import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.external.IngredientePersistenceDataBase;
import com.system.application.pizzaria.external.database.entity.IngredienteModel;
import com.system.application.pizzaria.external.database.entity.adapter.cadastro.IngredienteCadastroModelAdapter;
import com.system.application.pizzaria.external.database.entity.adapter.IngredienteModelAdapter;

import com.system.application.pizzaria.external.database.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class IngredientePersistenceDataBaseImpl implements IngredientePersistenceDataBase {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Override
    public List<Ingrediente> getAllIngredientes() {
        List<IngredienteModel> ingredienteModelList = ingredienteRepository.findAll();
        return IngredienteModelAdapter.modelListToEntityList(ingredienteModelList);
    }

    @Override
    public Ingrediente getIngredienteById(Integer idIngrediente) throws IngredienteException {
        try {
            IngredienteModel ingredienteModel = ingredienteRepository.getById(idIngrediente);
            return IngredienteModelAdapter.modelToEntity(ingredienteModel);
        }catch (Exception e){
            throw new IngredienteException(ErrorType.DATA_BASE_NOT_FOUND, String.format("DATABASE ingrediente NOT FOUND FOR ID: %d", idIngrediente),new Date() , HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Ingrediente saveIngrediente(Ingrediente ingrediente) throws IngredienteException {
        IngredienteModel ingredienteModel = IngredienteCadastroModelAdapter.entityToModel(ingrediente);
        try {
            ingredienteRepository.save(ingredienteModel);
            return IngredienteCadastroModelAdapter.modelToEntity(ingredienteModel);
        } catch (Exception e) {
            throw new IngredienteException(ErrorType.ERROR_DATABASE_SAVE, "Erro ao salvar Ingrediente", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


