package br.gama.itau.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gama.itau.projeto.model.Cliente;
import br.gama.itau.projeto.repositorio.ClienteRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepo repo;

    public Cliente cadastrarCliente(Cliente cliente) {
        return repo.save(cliente);
    }
    public List<Cliente> recuperarTodos() {
        return (List<Cliente>) repo.findAll();
    }

    public Cliente recuperarPeloID(int id) {
        return repo.findById(id).orElse(null);}

   
}
