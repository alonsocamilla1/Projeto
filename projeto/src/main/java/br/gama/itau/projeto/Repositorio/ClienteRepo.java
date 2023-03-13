package br.gama.itau.projeto.Repositorio;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projeto.Model.Cliente;

public interface ClienteRepo extends  CrudRepository<Cliente, Integer>{
    
}
