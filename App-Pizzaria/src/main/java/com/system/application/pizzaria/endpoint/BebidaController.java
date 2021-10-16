package com.system.application.pizzaria.endpoint;


import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.usecase.bebida.GetAllBebida;
import com.system.application.pizzaria.usecase.bebida.GetBebidaByld;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.adapter.BebidaVMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/bebida", produces = MediaType.APPLICATION_JSON_VALUE)
public class BebidaController {

    @Autowired
    private GetAllBebida getAllBebida;

    @Autowired
    private GetBebidaByld getBebidaById;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BebidaVM>> getAllBebidasController() {
        List<Bebida> listaBebidaEntity = getAllBebida.getAllBebidas();
        List<BebidaVM> listBebidaVM = BebidaVMAdapter.entityListToViewModelList(listaBebidaEntity);
        return ResponseEntity.ok().body(listBebidaVM);
    }


    @GetMapping("/{idBebida}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BebidaVM> getBebidaByIdController(@PathVariable Integer idBebida) throws BebidaException {
        Bebida bebidaEntity = getBebidaById.getBebidaById(idBebida);
        BebidaVM bebidaVM = BebidaVMAdapter.entityToViewModel(bebidaEntity);
        return ResponseEntity.ok().body(bebidaVM);
    }
}


