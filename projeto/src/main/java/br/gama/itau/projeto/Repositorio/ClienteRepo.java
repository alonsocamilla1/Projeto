package br.gama.itau.projeto.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projeto.model.Cliente;

public interface ClienteRepo extends  CrudRepository<Cliente, Integer>{
    
}
