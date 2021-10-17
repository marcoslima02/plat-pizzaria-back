package com.system.application.pizzaria.external.database.repository;

import com.system.application.pizzaria.external.database.entity.BebidaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BebidaRepository extends JpaRepository<BebidaModel, Integer> {
}

