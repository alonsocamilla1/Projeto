package br.gama.itau.projeto.service;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gama.itau.projeto.model.Movimentacao;
import br.gama.itau.projeto.repositorio.MovimentacaoRepo;

@Service
public class MovimentacaoService {

    // Injeção de dependência
    @Autowired
    private MovimentacaoRepo movimentacaoRepo;

    // Método que cadastra uma nova Movimentação
    // Recebe como parâmetro um objeto do tipo Movimentação que retorna os dados da movimentação
    public Movimentacao cadastrarMovimentacao(Movimentacao novaMovimentacao) {
        if(novaMovimentacao.getNumSeq() > 0) {
            return null;
        }
        Movimentacao movimentacaoCadastrada = movimentacaoRepo.save(novaMovimentacao);
        return movimentacaoCadastrada;
    }

    // Método que recebe um número da conta (numeroConta) e retorna uma lista de todas as movimentações de uma determinada conta
    // ===== Fazer com que retorne uma lista de movimentações através do número da conta (numeroConta) =====
    public List<Movimentacao> recuperarTodas(int numeroConta) {
        List<Movimentacao> lista = (List<Movimentacao>) movimentacaoRepo.findAll();

        lista = new ArrayList<>();

        for (Movimentacao movimentacao : lista) {
            lista.add(new Movimentacao(movimentacao));
        }

        return lista;
    }

        return (List<Movimentacao>) movimentacaoRepo.findAll();
    }
    
    

}
