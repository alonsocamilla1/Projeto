package br.gama.itau.projeto.Repositorio;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projeto.Model.*;

public interface ClienteRepo extends  CrudRepository<Cliente, Integer>{
    // O repositório herda a interface CrudRepository com os métodos para fazer operações CRUD do Cliente
}
