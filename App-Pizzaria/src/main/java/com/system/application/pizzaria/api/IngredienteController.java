package com.system.application.pizzaria.api;


import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Ingrediente;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.exception.IngredienteException;
import com.system.application.pizzaria.usecase.atendente.SaveAtendente;
import com.system.application.pizzaria.usecase.ingrediente.GetAllIngrediente;
import com.system.application.pizzaria.usecase.ingrediente.GetIngredienteByld;
import com.system.application.pizzaria.usecase.ingrediente.SaveIngrediente;
import com.system.application.pizzaria.viewmodel.IngredienteVM;
import com.system.application.pizzaria.viewmodel.adapter.IngredienteVMAdapter;
import com.system.application.pizzaria.viewmodel.adapter.cadastro.AtendenteCadastroVMAdapter;
import com.system.application.pizzaria.viewmodel.adapter.cadastro.IngredienteCadastroVMAdapter;
import com.system.application.pizzaria.viewmodel.cadastro.AtendenteCadastroVM;
import com.system.application.pizzaria.viewmodel.cadastro.IngredienteCadastroVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/ingrediente", produces = MediaType.APPLICATION_JSON_VALUE)
public class IngredienteController {

    @Autowired
    private SaveIngrediente saveIngrediente;

    @Autowired
    private GetAllIngrediente getAllIngrediente;

    @Autowired
    private GetIngredienteByld getIngredienteById;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<IngredienteVM>> getAllIngredientesController() {
        List<Ingrediente> listaIngredienteEntity = getAllIngrediente.getAllIngredientes();
        List<IngredienteVM> listIngredienteVM = IngredienteVMAdapter.entityListToViewModelList(listaIngredienteEntity);
        return ResponseEntity.ok().body(listIngredienteVM);
    }


    @GetMapping("/{idIngrediente}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<IngredienteVM> getIngredienteByIdController(@PathVariable Integer idIngrediente) throws IngredienteException {
        Ingrediente ingredienteEntity = getIngredienteById.getIngredienteById(idIngrediente);
        IngredienteVM ingredienteVM = IngredienteVMAdapter.entityToViewModel(ingredienteEntity);
        return ResponseEntity.ok().body(ingredienteVM);
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<com.system.application.pizzaria.viewmodel.cadastro.IngredienteCadastroVm> saveIngrediente(@RequestBody IngredienteCadastroVm ingredienteCadastroVM) throws IngredienteException {
        Ingrediente ingrediente = IngredienteCadastroVMAdapter.viewModelToEntity(ingredienteCadastroVM);
        IngredienteCadastroVm ingredienteCadastradoRetornado = IngredienteCadastroVMAdapter.entityToViewModel(saveIngrediente.saveIngrediente(ingrediente));
        return ResponseEntity.ok().body(ingredienteCadastradoRetornado);

    }

}


