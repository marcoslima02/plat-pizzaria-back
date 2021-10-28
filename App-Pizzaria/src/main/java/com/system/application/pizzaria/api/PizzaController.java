package com.system.application.pizzaria.api;

import com.system.application.pizzaria.entity.Pizza;

import com.system.application.pizzaria.exception.PizzaException;

import com.system.application.pizzaria.usecase.Pizza.GetAllPizza;
import com.system.application.pizzaria.usecase.Pizza.GetPizzaById;
import com.system.application.pizzaria.usecase.Pizza.SavePizza;
import com.system.application.pizzaria.viewmodel.PizzaCadastroVM;
import com.system.application.pizzaria.viewmodel.PizzaVM;
import com.system.application.pizzaria.viewmodel.adapter.PizzaCadastroVMAdapter;
import com.system.application.pizzaria.viewmodel.adapter.PizzaVMAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/pizza", produces = MediaType.APPLICATION_JSON_VALUE)
public class PizzaController {

    @Autowired
    private GetAllPizza getAllPizza;

    @Autowired
    private GetPizzaById getPizzaById;

    @Autowired
    private SavePizza savePizza;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<PizzaVM>> getAllPizzas() throws PizzaException {
        List<Pizza> listaPizzasEntity = getAllPizza.getAllPizzas();
        List<PizzaVM> listaPizzaVM = PizzaVMAdapter.entityListToEntityList(listaPizzasEntity);
        return ResponseEntity.ok().body(listaPizzaVM);
    }

    @GetMapping("/{idPizza}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PizzaVM> getPizzaById(@PathVariable Integer idPizza) throws PizzaException {
        Pizza pizzaEntity = getPizzaById.getPizzaById(idPizza);
        PizzaVM pizzaVM = PizzaVMAdapter.entityToViewModel(pizzaEntity);
        return ResponseEntity.ok().body(pizzaVM);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<PizzaCadastroVM> savePizzaController(@RequestBody final PizzaCadastroVM pizzaCadastroVM) throws PizzaException {
        Pizza pizza = PizzaCadastroVMAdapter.viewModelToEntity(pizzaCadastroVM);
        PizzaCadastroVM pizzaCadastroReturnDataBase = PizzaCadastroVMAdapter.entityToViewModel(savePizza.savePizza(pizza));
        return ResponseEntity.status(200).body(pizzaCadastroReturnDataBase);
    }

}
