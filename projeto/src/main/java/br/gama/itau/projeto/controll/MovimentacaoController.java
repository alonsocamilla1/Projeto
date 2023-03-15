package br.gama.itau.projeto.controll;


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

import br.gama.itau.projeto.Service.*;
import br.gama.itau.projeto.Model.*;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoService movimentacaoService;

    @PostMapping
    public ResponseEntity<Movimentacao> cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
        Movimentacao movimentacaoInserido = movimentacaoService.cadastrarMovimentacao(movimentacao);
        if (movimentacaoInserido == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(movimentacaoInserido);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movimentacao>> recuperarTodas(@PathVariable Integer id) {
        Optional<Movimentacao> movimentacao = movimentacaoService.recuperarTodas(id);
        return ResponseEntity.ok(movimentacao);
    }
}
