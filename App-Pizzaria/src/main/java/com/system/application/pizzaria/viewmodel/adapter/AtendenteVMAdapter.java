package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.AtendenteVM;
import com.system.application.pizzaria.viewmodel.PedidoVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtendenteVMAdapter {

    public static AtendenteVM entityToViewModel(Atendente atendente) throws AtendenteException {
        List<PedidoVM> listaPedidos = new ArrayList<>();
        AtendenteVM atendenteVM = new AtendenteVM();

        try {
            atendenteVM.setIdAtendenteVM(atendente.getIdAtendente());
            atendenteVM.setNomeUserVM(atendente.getNome());
            atendenteVM.setCpfUserVM(atendente.getCpf());
            atendenteVM.setApelidoUserVM(atendente.getApelido());
            atendenteVM.setSenhaUserVM(atendente.getSenha());
            atendenteVM.setTelefoneUserVM(atendente.getTelefone());
            atendenteVM.setHorarioTrabalhoFuncionarioVM(atendente.getHorarioTrabalho());
            atendenteVM.setSalarioFuncionarioVM(atendente.getSalario());

            //TODO: Trazer o adapter de Pedido entityToViewModel
//        for (Pedido pedido : atendente.getListapedidoAtendente()) {
//
//        }
//        atendenteVM.setListapedidoAtendente(listaPedidos);
            return atendenteVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Atendente para AtendenteVM");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Atendente viewModelToEntity(AtendenteVM atendenteVM) throws AtendenteException {
        List<Pedido> listaPedidos = new ArrayList<>();
        Atendente atendente = new Atendente();

        try {
            atendente.setIdAtendente(atendenteVM.getIdAtendenteVM());
            atendente.setNome(atendenteVM.getNomeUserVM());
            atendente.setCpf(atendenteVM.getCpfUserVM());
            atendente.setApelido(atendenteVM.getApelidoUserVM());
            atendente.setSenha(atendenteVM.getSenhaUserVM());
            atendente.setTelefone(atendenteVM.getTelefoneUserVM());
            atendente.setHorarioTrabalho(atendenteVM.getHorarioTrabalhoFuncionarioVM());
            atendente.setSalario(atendenteVM.getSalarioFuncionarioVM());

            //TODO: Trazer o adapter de Pedido viewModelToEntity
//        for (PedidoVM pedido: atendenteVM.getListapedidoAtendente()) {
//
//        }
            return atendente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteVM para Atendente");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static List<Atendente> viewModelListToEntityList(List<AtendenteVM> atendenteVMList){
        List<Atendente> atendenteList = new ArrayList<>();
        atendenteVMList.forEach(atendenteVM -> {
            try {
                atendenteList.add(viewModelToEntity(atendenteVM));
            } catch (AtendenteException e) {
                e.printStackTrace();
            }
        });
        return atendenteList;
    }

    public static List<AtendenteVM> entityListToViewModelList(List<Atendente> atendenteList){
        List<AtendenteVM> atendenteVMList = new ArrayList<>();
        atendenteList.forEach(atendente -> {
            try {
                atendenteVMList.add(entityToViewModel(atendente));
            } catch (AtendenteException e) {
                e.printStackTrace();
            }
        });
        return atendenteVMList;
    }
}
