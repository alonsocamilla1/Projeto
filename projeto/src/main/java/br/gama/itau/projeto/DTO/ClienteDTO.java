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
    private int id;
    private String nomeCliente;
    private String cpfCliente;
    private String telefoneCliente;

    public ClienteDTO(Cliente c) {
        this.id = c.getId();
        this.nomeCliente = c.getNomeCliente();
        this.cpfCliente = c.getCpfCliente();
        this.telefoneCliente = c.getTelefoneCliente();
}
}
