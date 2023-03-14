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
    
    // Injeção de dependência
    @Autowired
    private MovimentacaoService movimentacaoService;

    // /movimentacao (POST) - chama o serviço cadastrarMovimentacao, podendo retornar
    // 201 (created) se a movimentacao foi cadastrada com sucesso ou
    // 400 (bad request) se a movimentação não foi cadastrada com sucesso
    // ===== Inserir código que faça: se a movimentação não foi cadastrada com sucesso, retornar 400 (bad request) =====
    @PostMapping
    public ResponseEntity<Movimentacao> cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
        Movimentacao novaMovimentacao = movimentacaoService.cadastrarMovimentacao(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMovimentacao);
    }

    // /movimentacao/{id} (GET) - chama o serviço recuperarTodas
    @GetMapping("/{conta}")
    public ResponseEntity<List<Movimentacao>> recuperarMovimentacoesPorConta(@PathVariable Integer conta) {
        List<Movimentacao> movimentacoes = movimentacaoService.recuperarTodas(conta);
        return ResponseEntity.ok(movimentacoes);
    }
    
}
