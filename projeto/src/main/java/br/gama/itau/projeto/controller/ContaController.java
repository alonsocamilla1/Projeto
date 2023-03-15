package br.gama.itau.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.gama.itau.projeto.Model.*;
import br.gama.itau.projeto.Service.*;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

    // - /contas/{id} (GET)- chama o serviço recuperarPeloNumero,
    // podendo retornar 200 ou 404
    @GetMapping("/{numeroConta}")
    public Conta recuperarPeloNumero(@PathVariable Integer numeroConta) {
        return contaService.recuperarPeloNumero(numeroConta);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Conta>> recuperarContasPeloCliente(@PathVariable Integer id) {
        List<Conta> conta = contaService.recuperarContasPeloCliente(id);
        return ResponseEntity.ok().body(conta);
    }

    @PutMapping
    public Conta alterarDados(@RequestBody Conta conta) {
        return contaService.alterarDados(conta);
    }

    // - /contas (POST) - para cadastrar uma nova conta, chamando o serviço
    // adicionarConta, podendo retornar 201 ou 400
    
    @PostMapping // OK
    public ResponseEntity<Conta> adicionarConta(@RequestBody Conta conta) {
        Conta contaInserido = contaService.adicionarConta(conta);
        if (contaInserido == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contaInserido);
    }
   
   
   
   
   
   
    
    
    
    
    
    
    

}
