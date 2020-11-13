package io.github.sarahtoscano.clientes;

import io.github.sarahtoscano.clientes.model.entity.Cliente;
import io.github.sarahtoscano.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//Inicializa a aplicação e configura as dependencias

public class ClientesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientesApplication.class, args);
    }
}

