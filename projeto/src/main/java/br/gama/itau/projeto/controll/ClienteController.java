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

import br.gama.itau.projeto.model.Cliente;
import br.gama.itau.projeto.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    // Injeção de dependência
    @Autowired
    private ClienteService service;

    //-	/clientes (POST) - chama o serviço cadastrarCliente 
    // e pode retornar status 201 (created) ou 400 (bad request).
    // ===== Inserir código que faça: se não for criado, retornar 400 (bad request) =====
    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente c) {
        Cliente clienteCadastrado = service.cadastrarCliente(c);
        return new ResponseEntity<Cliente>(clienteCadastrado, HttpStatus.CREATED);
    }

    //-	/clientes (GET) - chama o serviço recuperarTodos
    @GetMapping
    public ResponseEntity<List<Cliente>> recuperarTodos() {
        List<Cliente> clientes = service.recuperarTodos();
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }


    //-	/clientes/{id} (GET) - chama o serviço recuperarPeloId e 
    //pode retornar status 200 (ok) se o cliente existir ou 404 (not found) se o cliente não existir
    // ===== Inserir código que faça: se o cliente não existir, retornar 404 (not found) =====
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> recuperarPeloID(@PathVariable int id) {
        Cliente cliente = service.recuperarPeloId(id);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
}
