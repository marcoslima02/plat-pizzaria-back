package com.system.application.pizzaria.external.database.repository;

import com.system.application.pizzaria.external.database.entity.PizzaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaModel, Integer> {
}
