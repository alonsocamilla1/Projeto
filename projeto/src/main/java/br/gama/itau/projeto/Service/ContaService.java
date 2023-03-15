package br.gama.itau.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import br.gama.itau.projeto.exception.NotFoundException;
import br.gama.itau.projeto.model.Cliente;
import br.gama.itau.projeto.model.Conta;
import br.gama.itau.projeto.repositorio.*;

import org.springframework.stereotype.Service;

@Service
public class ContaService {

    
    // Injeção de dependências
    @Autowired
    private ContaRepo repo;

    @Autowired
    private ClienteRepo clienteRepository;

    // Método que recebe um número da conta e retorna os dados dessa conta se for
    // encontrada
    // Senão, retorna uma exceção
    public Conta recuperarPeloNumero(Integer numeroConta) {
        Optional<Conta> contaOptional = repo.findById(numeroConta);
        if (contaOptional.isPresent()) {
            return contaOptional.get();
        } else {
            throw new NotFoundException("Cliente não encontrado");
        }
    }

    public List<Conta> recuperarContasPeloCliente(int id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return repo.findByCliente(cliente);
    }

    public Conta alterarDados(Conta conta) {
        return repo.save(conta);
    }

    // Método que adicionas uma nova conta
    // Recebe como parâmetro uma conta (com ID do seu cliente) e retorna seus dados
    // completos caso tenha sido adicionado com sucessos
    // Senão, retorna nulo (null)
    public Conta adicionarConta(Conta conta) {
        Conta contaInserido =  repo.save(conta);
        return contaInserido;
    }

}
