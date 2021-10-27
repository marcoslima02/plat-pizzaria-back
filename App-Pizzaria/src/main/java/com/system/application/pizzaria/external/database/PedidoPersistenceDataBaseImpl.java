package com.system.application.pizzaria.external.database;

import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.ClienteException;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.external.PedidoPersistenceDataBase;
import com.system.application.pizzaria.external.database.entity.PedidoModel;
import com.system.application.pizzaria.external.database.entity.adapter.PedidoCadastroModelAdapter;
import com.system.application.pizzaria.external.database.entity.adapter.PedidoModelAdapter;
import com.system.application.pizzaria.external.database.entity.adapter.PedidoModelAdapter;
import com.system.application.pizzaria.external.database.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PedidoPersistenceDataBaseImpl implements PedidoPersistenceDataBase {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Override
    public List<Pedido> getAllPedidos() {
        List<PedidoModel> pedidoModelList = pedidoRepository.findAll();
        return PedidoModelAdapter.modelListToEntityList(pedidoModelList);
    }

    @Override
    public Pedido getPedidoById(Integer idPedido) throws PedidoException {
        try {
            PedidoModel pedidoModel = pedidoRepository.getById(idPedido);
            return PedidoModelAdapter.modelToEntity(pedidoModel);
        } catch (Exception e) {
            throw new PedidoException(ErrorType.DATA_BASE_NOT_FOUND, String.format("DATABASE pedido NOT FOUND FOR ID: %d", idPedido), new Date(), HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Pedido savePedido(Pedido pedido) throws PedidoException {
        PedidoModel pedidoModel = PedidoCadastroModelAdapter.entityToModel(pedido);
        try {
            pedidoRepository.save(pedidoModel);
            return PedidoCadastroModelAdapter.modelToEntity(pedidoModel);
        }catch (Exception e){
            throw new PedidoException(ErrorType.ERROR_DATABASE_SAVE, "Erro ao salvar Pedido", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
