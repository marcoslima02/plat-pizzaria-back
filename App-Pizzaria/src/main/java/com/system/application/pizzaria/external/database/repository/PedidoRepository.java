package com.system.application.pizzaria.external.database.repository;


import com.system.application.pizzaria.external.database.entity.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {
}
