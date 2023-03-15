package br.gama.itau.projeto.dto;


import br.gama.itau.projeto.model.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {
    // DTO (Data Transfer Object) = Objeto usado para transferência de dados, geralmente aplicando um filtro nos dados originais
    private String nomeCliente;
    private String cpfCliente;
    private String telefoneCliente;

    public ClienteDTO(Cliente conta) {
        this.nomeCliente = conta.getNomeCliente();
        this.cpfCliente = conta.getCpfCliente();
        this.telefoneCliente = conta.getTelefoneCliente();
}
}
