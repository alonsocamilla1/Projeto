package br.gama.itau.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import  br.gama.itau.projeto.exception.NotFoundException;
import org.springframework.stereotype.Service;

import br.gama.itau.projeto.model.Cliente;
import br.gama.itau.projeto.model.Conta;
import br.gama.itau.projeto.repositorio.ClienteRepo;
import br.gama.itau.projeto.repositorio.ContaRepo;

@Service
public class ContaService {

    @Autowired
    private ContaRepo repo;

    @Autowired
    private ClienteRepo clienteRepository;
    
    public Conta adicionarConta(Conta c) {
        if(c.getNumeroConta() > 0) {
            return null;
        }
        Conta contaAdicionada = repo.save(c);
        return contaAdicionada;
       
    }

    public Conta recuperarPeloNumero(int numeroConta) {
        Optional <Conta> contaOptional= repo.findById(numeroConta);
        if(contaOptional.isEmpty()) {
            throw new NotFoundException("Conta não encontrada"); 
        } 
            Conta contaEncontrada = contaOptional.get();
            return contaEncontrada;
        }

    public Conta alterarDados(double saldo, Conta c, int numeroConta) {
        Optional<Conta> contaOptional = repo.findById(numeroConta);

        if(contaOptional.isEmpty()) {
            return null;
        }
        c.setSaldo(saldo);
        Conta saldoAtualizado = repo.save(c);
        return saldoAtualizado;
    }

    public List<Conta> recuperarContasPeloCliente(int id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return repo.findByCliente(cliente);
        }
}


