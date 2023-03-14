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
    // podendo retornar 200 ou 404s
    @GetMapping("/{numeroConta}")
    public Conta recuperarPeloNumero(@PathVariable int numeroConta) {
        return contaService.recuperarPeloNumero(numeroConta);
    }

    @GetMapping
    public ResponseEntity<List<Conta>> recuperarTodos() {
        List<Conta> contas = contaService.recuperarTodos();
        return new ResponseEntity<List<Conta>>(contas, HttpStatus.OK);
    }

    // - /contas (POST) - para cadastrar uma nova conta, chamando o serviço
    // adicionarConta, podendo retornar 201 ou 400
    @PostMapping
    public ResponseEntity<Conta> adicionarConta(@RequestBody Conta conta) {
        Conta contaInserido = contaService.adicionarConta(conta);
        if (contaInserido == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contaInserido);
    }

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