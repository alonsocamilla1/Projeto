package br.gama.itau.projeto.repositorio;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gama.itau.projeto.model.*;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContaRepo extends CrudRepository<Conta, Integer>{
   List<Conta> findByCliente(Optional<Cliente> cliente);





//Optional<Conta> findByNumero(int contaOrigem);
//Optional<Conta> findByNumero(int contaDestino);

//Conta findByNumero(int contaOrigem);

//Conta findByNumeroConta(String numeroContaOrigem);
  
}
