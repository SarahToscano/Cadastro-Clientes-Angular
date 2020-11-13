package io.github.sarahtoscano.clientes.rest;

import io.github.sarahtoscano.clientes.model.entity.Cliente;
import io.github.sarahtoscano.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")//Libera p dominio diferentes

public class ClienteController {

    private final ClienteRepository repository;

    @Autowired
    public ClienteController(ClienteRepository repository) {

        this.repository = repository;
    }

    @GetMapping
    public List<Cliente> listarTodos(){
        return repository.findAll();
    }

    @PostMapping //Cria o recurso no servidor - salvar pela primeira vez o cliente
    @ResponseStatus(HttpStatus.CREATED) //codigo de status para salvo com sucesso
    public Cliente salvar (@RequestBody @Valid Cliente cliente){
        return repository.save(cliente);
    }

    @GetMapping("{id}")
    public Cliente procurarPorId(@PathVariable Integer id){
        return repository
                .findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
         repository
                .findById(id)
                 .map( cliente ->{
                     repository.delete(cliente);
                     return Void.TYPE;
                 })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody @Valid Cliente clienteAtualizado ){
        repository
                .findById(id)
                .map( cliente ->{
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    return repository.save(cliente);
                })
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }
}
