package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.AtendenteVM;
import com.system.application.pizzaria.viewmodel.PedidoVM;

import java.util.ArrayList;
import java.util.List;

public class AtendenteVMAdapter {

    public static AtendenteVM entityToViewModel(Atendente atendente) {
        List<PedidoVM> listaPedidos = new ArrayList<>();
        AtendenteVM atendenteVM = new AtendenteVM();

        try {
            atendenteVM.setIdAtendenteVM(atendente.getIdAtendente());
            atendenteVM.setNome(atendente.getNome());
            atendenteVM.setCpf(atendente.getCpf());
            atendenteVM.setApelido(atendente.getApelido());
            atendenteVM.setSenha(atendente.getSenha());
            atendenteVM.setTelefone(atendente.getTelefone());
            atendenteVM.setHorarioTrabalho(atendente.getHorarioTrabalho());
            atendenteVM.setSalario(atendente.getSalario());

            //TODO: Trazer o adapter de Pedido entityToViewModel
//        for (Pedido pedido : atendente.getListapedidoAtendente()) {
//
//        }
//        atendenteVM.setListapedidoAtendente(listaPedidos);
            return atendenteVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Atendente para AtendenteVM");
            throw new AtendenteException(AtendenteException.ErrorType.VALIDATIONS, "Adapter entityToViewModel Atendente is Null");
        }
    }

    public static Atendente viewModelToEntity(AtendenteVM atendenteVM) {
        List<Pedido> listaPedidos = new ArrayList<>();
        Atendente atendente = new Atendente();

        try {
            atendente.setIdAtendente(atendenteVM.getIdAtendenteVM());
            atendente.setNome(atendenteVM.getNome());
            atendente.setCpf(atendenteVM.getCpf());
            atendente.setApelido(atendenteVM.getApelido());
            atendente.setSenha(atendenteVM.getSenha());
            atendente.setTelefone(atendenteVM.getTelefone());
            atendente.setHorarioTrabalho(atendenteVM.getHorarioTrabalho());
            atendente.setSalario(atendenteVM.getSalario());

            //TODO: Trazer o adapter de Pedido viewModelToEntity
//        for (PedidoVM pedido: atendenteVM.getListapedidoAtendente()) {
//
//        }
            return atendente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteVM para Atendente");
            throw new AtendenteException(AtendenteException.ErrorType.VALIDATIONS, "Adapter viewModelToEntity Atendente is Null");
        }
    }
}
