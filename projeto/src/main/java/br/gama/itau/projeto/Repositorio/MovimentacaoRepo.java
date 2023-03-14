package br.gama.itau.projeto.repositorio;

import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projeto.model.Movimentacao;

public interface MovimentacaoRepo extends CrudRepository<Movimentacao, Integer>{
    // O repositório herda a interface CrudRepository com os métodos para fazer operações CRUD da Movimentacao
}
