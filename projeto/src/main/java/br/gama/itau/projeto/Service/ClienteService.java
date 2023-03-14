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
    
    // Injeção de dependência
    @Autowired
    private ClienteRepo repo;

    // Método que cadastra um novo cliente
    // Recebe como entrada um objeto do tipo cliente e retorna-o completo caso ele tenha sido cadastrado com sucesso
    // Senão, retorna nulo (null)
    public Cliente cadastrarCliente(Cliente novoCliente) {
        if(novoCliente.getId() > 0) {
            return null;
        }
        Cliente clienteInserido = repo.save(novoCliente);
        return clienteInserido; 
    }
    
    // Método que retorna uma lista com todos os clientes cadastrados (apenas dados de cliente)
    public List<Cliente> recuperarTodos() {
        return (List<Cliente>) repo.findAll();
    }

    // Método que recebeum ID de cliente e retorna seus dados
    // Caso não foi encontrado, retorna nulo (null)
    public Cliente recuperarPeloID(int id) {
        return repo.findById(id).orElse(null);}

   
}
