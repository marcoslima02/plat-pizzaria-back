package com.system.application.pizzaria.viewmodel;

import com.system.application.pizzaria.external.database.entity.FuncionarioModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CozinheiroVM extends FuncionarioModel {

    private Integer idCozinheiroVM;
    private List<PedidoVM> listaPizzaPedidoVM;
    private List<IngredienteVM> listaIngredientesPizzaVM;
}
