package com.system.application.pizzaria.viewmodel;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class CozinheiroVM extends FuncionarioVM {

    private Integer idCozinheiroVM;
    private List<PedidoVM> listaPedidoVMCozinheiroVM;
    private List<IngredienteVM> listaIngredientesPizzaVMCozinheiroVM;
}
