package com.system.application.pizzaria.external.database.repository;

import com.system.application.pizzaria.external.database.entity.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Integer> {

    ClienteModel findByCpfModel(String cpfCliente);
    Boolean existsByCpfModel(String cpfCliente);
    Boolean existsBySenhaModel(String senhaCliente);
}
