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

import br.gama.itau.projeto.model.Conta;
import br.gama.itau.projeto.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    // - /contas/{id} (GET)- chama o serviço recuperarPeloNumero,
    // podendo retornar 200 (ok) ou 404 (not found)
    // ===== Inserir código que faça: se o número não for encontrado, retornar 404 (not found) =====
    // ===== Inserir também, código que faça: se o número for encontrado, retornar 200 (ok) =====
    @GetMapping("/{numeroConta}")
    public Conta recuperarPeloNumero(@PathVariable int numeroConta) {
        return contaService.recuperarPeloNumero(numeroConta);
    }

    // * Este método não foi pedido
    @GetMapping
    public ResponseEntity<List<Conta>> recuperarTodos() {
        List<Conta> contas = contaService.recuperarTodos();
        return new ResponseEntity<List<Conta>>(contas, HttpStatus.OK);
    }

    // - /contas (POST) - para cadastrar uma nova conta, chamando o serviço
    // adicionarConta, podendo retornar 201 (created) se a conta for criada com sucesso
    // ou 400 (bad request) se a conta não for criada com sucesso
    @PostMapping
    public ResponseEntity<Conta> adicionarConta(@RequestBody Conta conta) {
        Conta contaInserido = contaService.adicionarConta(conta);
        if (contaInserido == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contaInserido);
    }

    // /contas/cliente/{id} (GET) - chama o serviço recuperarPeloId
    // e pode retornar status 200 (ok) se o cliente for encontrado
    // ou 404 (not found) se o cliente não existir
    // ===== Inserir código que faça: se o id do cliente não for encontrado, retornar 404 (not found) =====
    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Conta>> recuperarContasPeloCliente(@PathVariable int id) {
        List<Conta> conta = contaService.recuperarContasPeloCliente(id);
        return ResponseEntity.ok().body(conta);
    }

   // @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    //public Conta adicionarConta(@RequestBody Conta conta) {
      //  contaService.adicionarConta(conta);
    //}

    // - /contas/{id} (GET)- chama o serviço recuperarPeloNumero,
    // podendo retornar 200 ou 404sss
    /*
     * @GetMapping("/{numero_conta}")
     * public ResponseEntity<Conta> recuperarPeloNumero(@PathVariable Long
     * numero_conta) {
     * Conta conta = contaService.recuperarPeloNumero(numero_conta);
     * return new ResponseEntity<Conta>(conta, HttpStatus.OK);
     * }
     */

    /*
     * @PostMapping
     * public ResponseEntity<Conta> adicionarConta(@RequestBody Conta conta) {
     * Conta contaAdicionada = contaService.adicionarConta(conta);
     * return ResponseEntity.status(HttpStatus.CREATED).body(contaAdicionada);
     * }
     */

}
