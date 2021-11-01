package com.system.application.pizzaria.api;


import com.system.application.pizzaria.entity.Bebida;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.BebidaException;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.usecase.Pedido.EnricherPedido;
import com.system.application.pizzaria.usecase.bebida.GetAllBebida;
import com.system.application.pizzaria.usecase.bebida.GetBebidaByld;
import com.system.application.pizzaria.usecase.bebida.SaveBebida;
import com.system.application.pizzaria.viewmodel.BebidaVM;
import com.system.application.pizzaria.viewmodel.adapter.BebidaVMAdapter;
import com.system.application.pizzaria.viewmodel.adapter.forms.BebidaCadastroVMAdapter;
import com.system.application.pizzaria.viewmodel.cadastro.BebidaCadastroVM;
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
    private SaveBebida saveBebida;

    @Autowired
    private GetAllBebida getAllBebida;

    @Autowired
    private GetBebidaByld getBebidaById;

    @Autowired
    private EnricherPedido enricherPedido;

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

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BebidaCadastroVM> saveBebida(@RequestBody BebidaCadastroVM bebidaCadastroVM) throws BebidaException, PedidoException {
        Bebida bebida = BebidaCadastroVMAdapter.viewModelToEntity(bebidaCadastroVM);
        if(bebida.getIdentificacaoPedido() != null){
            Pedido pedidoEnriquecido = enricherPedido.enricherPedido(bebida.getIdentificacaoPedido());
            bebida.setPedidoEntidade(pedidoEnriquecido);
        }
        BebidaCadastroVM bebidaCadastradoRetornado = BebidaCadastroVMAdapter.entityToViewModel(saveBebida.saveBebida(bebida));
        return ResponseEntity.ok().body(bebidaCadastradoRetornado);
    }

}
