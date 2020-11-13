package io.github.sarahtoscano.clientes.model.repository;

import io.github.sarahtoscano.clientes.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository <Servico, Integer> {

}
