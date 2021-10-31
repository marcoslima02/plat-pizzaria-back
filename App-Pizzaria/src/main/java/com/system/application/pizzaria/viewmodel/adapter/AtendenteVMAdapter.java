package com.system.application.pizzaria.viewmodel.adapter;

import com.system.application.pizzaria.entity.Atendente;
import com.system.application.pizzaria.entity.Pedido;
import com.system.application.pizzaria.entity.enums.ErrorType;
import com.system.application.pizzaria.exception.AtendenteException;
import com.system.application.pizzaria.exception.PedidoException;
import com.system.application.pizzaria.util.ConfigUtils;
import com.system.application.pizzaria.viewmodel.AtendenteVM;
import com.system.application.pizzaria.viewmodel.AtendenteVMCadastroInfo;
import com.system.application.pizzaria.viewmodel.PedidoVM;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtendenteVMAdapter {

    public static Atendente viewModelToEntityInfo(AtendenteVMCadastroInfo atendenteVMCadastroInfo) throws AtendenteException {
        Atendente atendente = new Atendente();
        try{
            atendente.setIdAtendente(atendenteVMCadastroInfo.getIdAtendenteVM());
            atendente.setNome(atendenteVMCadastroInfo.getNomeVM());
            atendente.setCpf(atendenteVMCadastroInfo.getCpfVM());
            return atendente;
        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de atendenteVMCadastroInfo para Atendente");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter ViewModelToEntityInfo atendenteVMCadastroInfo is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static AtendenteVMCadastroInfo entityToViewModelInfo(Atendente atendente) throws AtendenteException {
        AtendenteVMCadastroInfo atendenteVMCadastroInfo = new AtendenteVMCadastroInfo();
        try{
            atendenteVMCadastroInfo.setIdAtendenteVM(atendente.getIdAtendente());
            atendenteVMCadastroInfo.setNomeVM(atendente.getNome());
            atendenteVMCadastroInfo.setCpfVM(atendente.getCpf());
            return atendenteVMCadastroInfo;
        }catch (Exception e){
            ConfigUtils.logger.warning("Error ao fazer adapter de atendente para AtendenteVMCadastroInfo");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter entityToViewModelInfo atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static AtendenteVM entityToViewModel(Atendente atendente) throws AtendenteException {
        List<PedidoVM> listaPedidos = new ArrayList<>();
        AtendenteVM atendenteVM = new AtendenteVM();

        try {
            atendenteVM.setIdAtendenteVM(atendente.getIdAtendente());
            atendenteVM.setNomeVM(atendente.getNome());
            atendenteVM.setCpfVM(atendente.getCpf());
            atendenteVM.setApelidoVM(atendente.getApelido());
            atendenteVM.setSenhaVM(atendente.getSenha());
            atendenteVM.setTelefoneVM(atendente.getTelefone());
            atendenteVM.setHorarioTrabalhoVM(atendente.getHorarioTrabalho());
            atendenteVM.setSalarioVM(atendente.getSalario());
            validateIsNullEntityToModel(atendente, listaPedidos);
            atendenteVM.setListapedidoAtendente(listaPedidos);
            return atendenteVM;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de Atendente para AtendenteVM");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter entityToViewModel Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateIsNullEntityToModel(Atendente atendente, List<PedidoVM> listaPedidos) {
        if (atendente.getListapedidoAtendente() != null) {
            percorreListapedidoEntityToVM(atendente, listaPedidos);
        }
    }

    private static void percorreListapedidoEntityToVM(Atendente atendente, List<PedidoVM> listaPedidos) {
        atendente.getListapedidoAtendente().forEach(pedido -> {
            try {
                listaPedidos.add(PedidoVMAdapter.entityToViewModel(pedido));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
    }

    public static Atendente viewModelToEntity(AtendenteVM atendenteVM) throws AtendenteException {
        List<Pedido> listaPedidos = new ArrayList<>();
        Atendente atendente = new Atendente();

        try {
            atendente.setIdAtendente(atendenteVM.getIdAtendenteVM());
            atendente.setNome(atendenteVM.getNomeVM());
            atendente.setCpf(atendenteVM.getCpfVM());
            atendente.setApelido(atendenteVM.getApelidoVM());
            atendente.setSenha(atendenteVM.getSenhaVM());
            atendente.setTelefone(atendenteVM.getTelefoneVM());
            atendente.setHorarioTrabalho(atendenteVM.getHorarioTrabalhoVM());
            atendente.setSalario(atendenteVM.getSalarioVM());
            validateIsNullViewModelToEntity(atendenteVM, listaPedidos);
            return atendente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteVM para Atendente");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static Atendente viewModelToEntityAtendenteInfo(AtendenteVM atendenteVM) throws AtendenteException {
        Atendente atendente = new Atendente();

        try {
            atendente.setIdAtendente(atendenteVM.getIdAtendenteVM());
            atendente.setNome(atendenteVM.getNomeVM());
            atendente.setCpf(atendenteVM.getCpfVM());
            atendente.setApelido(atendenteVM.getApelidoVM());
            atendente.setSenha(atendenteVM.getSenhaVM());
            atendente.setTelefone(atendenteVM.getTelefoneVM());
            atendente.setHorarioTrabalho(atendenteVM.getHorarioTrabalhoVM());
            atendente.setSalario(atendenteVM.getSalarioVM());
            return atendente;
        } catch (Exception e) {
            ConfigUtils.logger.warning("Error ao fazer adapter de AtendenteVM para Atendente");
            throw new AtendenteException(ErrorType.VALIDATIONS, "Adapter viewModelToEntity Atendente is Null", new Date(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static void validateIsNullViewModelToEntity(AtendenteVM atendenteVM, List<Pedido> listaPedidos) {
        if(atendenteVM.getListapedidoAtendente() != null){
            percorreListaPedidoVmToEntity(atendenteVM, listaPedidos);
        }

    }

    private static void percorreListaPedidoVmToEntity(AtendenteVM atendenteVM, List<Pedido> listaPedidos) {
        atendenteVM.getListapedidoAtendente().forEach(pedidoVM -> {
            try {
                listaPedidos.add(PedidoVMAdapter.viewModelToEntity(pedidoVM));
            } catch (PedidoException e) {
                e.printStackTrace();
            }
        });
    }

    public static List<Atendente> viewModelListToEntityList(List<AtendenteVM> atendenteVMList) {
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

    public static List<AtendenteVM> entityListToViewModelList(List<Atendente> atendenteList) {
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
