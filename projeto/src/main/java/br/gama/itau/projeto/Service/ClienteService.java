package br.gama.itau.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gama.itau.projeto.model.Cliente;
import br.gama.itau.projeto.repositorio.ClienteRepo;
import  br.gama.itau.projeto.exception.NotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepo repo;

    public Cliente cadastrarCliente(Cliente novoCliente) {
        if(novoCliente.getIdCliente() > 0) {
            return null;
        }
        Cliente clienteInserido = repo.save(novoCliente);
        return clienteInserido; 
    }

    public List<Cliente> recuperarTodos() {
        return (List<Cliente>) repo.findAll();
    }

    public Cliente recuperarPeloId(int idCliente) {
        Optional<Cliente> clienteOptional = repo.findById(idCliente);

        if (clienteOptional.isEmpty()) {
            throw new NotFoundException("Cliente não encontrado");
        }

        Cliente clienteEncontrado = clienteOptional.get();
        return clienteEncontrado;
    }

   
}
