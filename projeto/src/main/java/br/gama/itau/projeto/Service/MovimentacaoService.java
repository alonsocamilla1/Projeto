package br.gama.itau.projeto.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gama.itau.projeto.model.Movimentacao;
import br.gama.itau.projeto.repositorio.MovimentacaoRepo;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepo movimentacaoRepo;

    public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepo.save(movimentacao);
    }

    public List<Movimentacao> recuperarTodas(int numeroConta) {
        return (List<Movimentacao>) movimentacaoRepo.findAll();
    }
    
    

}