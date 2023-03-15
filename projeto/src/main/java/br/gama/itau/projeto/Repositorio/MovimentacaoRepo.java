package br.gama.itau.projeto.Repositorio;


import org.springframework.data.repository.CrudRepository;
import br.gama.itau.projeto.Model.*;

public interface  MovimentacaoRepo extends CrudRepository <Movimentacao, Integer> {
    // O repositório herda a interface CrudRepository com os métodos para fazer operações CRUD da Movimentacao
}
