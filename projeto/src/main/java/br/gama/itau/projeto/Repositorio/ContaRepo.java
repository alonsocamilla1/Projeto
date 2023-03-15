package br.gama.itau.projeto.Repositorio;


import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import br.gama.itau.projeto.Model.*;


public interface ContaRepo extends CrudRepository<Conta, Integer>{
   List<Conta> findByCliente(Optional<Cliente> cliente);
  
}
