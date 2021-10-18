package com.system.application.pizzaria.viewmodel;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
public class CozinheiroVM extends FuncionarioVM {

    private Integer idCozinheiroVM;
    private List<PedidoVM> listaPizzaPedidoVMCozinheiroVM;
    private List<IngredienteVM> listaIngredientesPizzaVMCozinheiroVM;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CozinheiroVM that = (CozinheiroVM) o;
        return Objects.equals(idCozinheiroVM, that.idCozinheiroVM);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
