package com.system.application.pizzaria.api;

import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.usecase.Pedido.GetAllPedido;
import com.system.application.pizzaria.usecase.Pedido.GetPedidoById;
import com.system.application.pizzaria.usecase.Pedido.SavePedido;
import com.system.application.pizzaria.viewmodel.cadastro.PedidoCadastroVM;
import com.system.application.pizzaria.viewmodel.PedidoVM;
import com.system.application.pizzaria.viewmodel.adapter.cadastro.PedidoCadastroVMAdapter;
import com.system.application.pizzaria.viewmodel.adapter.PedidoVMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/pedido", produces = MediaType.APPLICATION_JSON_VALUE)
public class PedidoController {

    @Autowired
    private GetAllPedido getAllPedido;

    @Autowired
    private GetPedidoById getPedidoById;

    @Autowired
    private SavePedido savePedido;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PedidoVM>> getAllPedidos() throws PedidoException {
        List<Pedido> listaPedidosEntity = getAllPedido.getAllPedidos();
        List<PedidoVM> listaPedidoVM = PedidoVMAdapter.entityListToViewModelList(listaPedidosEntity);
        return ResponseEntity.ok().body(listaPedidoVM);
    }

    @GetMapping("/{idPedido}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PedidoVM> getPedidoById(@PathVariable Integer idPedido) throws PedidoException {
        Pedido pedidoEntity = getPedidoById.getPedidoById(idPedido);
        PedidoVM pedidoVM = PedidoVMAdapter.entityToViewModel(pedidoEntity);
        return ResponseEntity.ok().body(pedidoVM);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<PedidoCadastroVM> savePedidoController(@RequestBody final PedidoCadastroVM pedidoCadastroVM) throws PedidoException {
        Pedido pedido = PedidoCadastroVMAdapter.viewModelToEntity(pedidoCadastroVM);
        PedidoCadastroVM pedidoCadastroVMRetornado = PedidoCadastroVMAdapter.entityToViewModel(savePedido.savePedido(pedido));
        return ResponseEntity.ok().body(pedidoCadastroVMRetornado);
    }
}
