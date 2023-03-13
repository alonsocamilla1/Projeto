package br.gama.itau.projeto.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projeto.model.Movimentacao;

public interface MovimentacaoRepo extends CrudRepository<Movimentacao, Integer>{
    
}
