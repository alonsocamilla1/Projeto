package br.gama.itau.projeto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import br.gama.itau.projeto.dto.ClienteDTO;
import br.gama.itau.projeto.model.Cliente;
import br.gama.itau.projeto.repositorio.ClienteRepo;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepo repo;
 
    public Cliente cadastrarCliente(Cliente c) {
        if(c.getId() > 0) {
            return null;
        }
        Cliente clienteInserido = repo.save(c);
        return clienteInserido;
    }
    
    

    public List<ClienteDTO> recuperarTodos() {
        List<Cliente> lista = (List<Cliente>) repo.findAll();

        List<ClienteDTO> listaDTO = new ArrayList<>();

        for (Cliente c : lista) {
            listaDTO.add(new ClienteDTO(c));
        }

        return listaDTO;
    }

    public Cliente recuperarPeloID(int id) throws NotFoundException{
        Optional<Cliente> clienteOptional = repo.findById(id);

        if (clienteOptional.isEmpty()) {
            throw new NotFoundException();
        }

        Cliente clienteEncontrado = clienteOptional.get();
        return clienteEncontrado;
    }
   
}
