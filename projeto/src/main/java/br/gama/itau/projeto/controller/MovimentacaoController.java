package br.gama.itau.projeto.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.itau.projeto.model.*;
import br.gama.itau.projeto.repositorio.MovimentacaoRepo;
import br.gama.itau.projeto.service.*;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @Autowired
    private ContaService contaService;

    @Autowired
    private MovimentacaoRepo movimentacaoRepo;

    
    @PostMapping
    public Movimentacao cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
       // return movimentacaoRepo.save(movimentacao);

        // ajustar o saldo
        Conta conta = contaService.recuperarPeloNumero(movimentacao.getConta().getNumeroConta());
        double saldo = conta.getSaldo();

        if (movimentacao.getTipoOperacao() == 1) {
            saldo = saldo + movimentacao.getValor();
        } else {
            saldo = saldo - movimentacao.getValor();
        }

        contaService.alterarSaldo(conta, saldo);

        // depois grava a movimentação
        Movimentacao movimentacaoInserido = movimentacaoRepo.save(movimentacao);
        
        return movimentacaoInserido;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movimentacao>> recuperarTodas(@PathVariable Integer id) {
        Optional<Movimentacao> movimentacao = movimentacaoService.recuperarTodas(id);
        return ResponseEntity.ok(movimentacao);
    }
}
