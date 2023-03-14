package br.gama.itau.projeto.controll;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gama.itau.projeto.model.Movimentacao;
import br.gama.itau.projeto.service.MovimentacaoService;


@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService movimentacaoService;

    
    
    @PostMapping
    public ResponseEntity<Movimentacao> cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
        Movimentacao novaMovimentacao = movimentacaoService.cadastrarMovimentacao(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMovimentacao);
    }

    @GetMapping("/{conta}")
    public ResponseEntity<List<Movimentacao>> recuperarMovimentacoesPorConta(@PathVariable Integer conta) {
        List<Movimentacao> movimentacoes = movimentacaoService.recuperarTodas(conta);
        return ResponseEntity.ok(movimentacoes);
    }
    
}