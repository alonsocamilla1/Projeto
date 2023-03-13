package br.gama.itau.projeto.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projeto.model.Conta;

public interface ContaRepo extends CrudRepository<Conta, Integer>{
    
}