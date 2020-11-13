package io.github.sarahtoscano.clientes.model.repository;

import io.github.sarahtoscano.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Integer> {



}
