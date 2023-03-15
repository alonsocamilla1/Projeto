package br.gama.itau.projeto.repositorio;


import org.springframework.data.repository.CrudRepository;

import br.gama.itau.projeto.model.*;

import java.util.List;
import java.util.Optional;


public interface ContaRepo extends CrudRepository<Conta, Integer>{
   List<Conta> findByCliente(Optional<Cliente> cliente);
  
}
