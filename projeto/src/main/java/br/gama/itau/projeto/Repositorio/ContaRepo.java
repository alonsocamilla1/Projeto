package br.gama.itau.projeto.repositorio;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import br.gama.itau.projeto.model.Cliente;
import br.gama.itau.projeto.model.Conta;

public interface ContaRepo extends CrudRepository<Conta, Integer>{
    // O repositório herda a interface CrudRepository com os métodos para fazer operações CRUD da Conta
    
    // Declarando Query Methods
    List<Conta> findByCliente(Cliente cliente);
}
