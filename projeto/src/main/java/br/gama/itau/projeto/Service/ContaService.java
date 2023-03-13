package br.gama.itau.projeto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.gama.itau.projeto.model.Conta;
import br.gama.itau.projeto.repositorio.ContaRepo;

@Service
public class ContaService {

    @Autowired
    private ContaRepo repo;
    
    public Conta adicionarConta(Conta c) {
        if(c.getNumeroConta() > 0) {
            return null;
        }
        Conta clienteInserido = repo.save(c);
        return clienteInserido;
    }

    public Conta recuperarPeloID(int id) throws NotFoundException{
        Optional<Conta> contaOptional = repo.findById(id);

        if (contaOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Conta clienteEncontrado = contaOptional.get();
        return clienteEncontrado;
    }    
}

