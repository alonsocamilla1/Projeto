package br.gama.itau.projeto.DTO;

import br.gama.itau.projeto.Model.*;
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
        this.id = c.getIdCliente();
        this.nomeCliente = c.getNomeCliente();
        this.cpfCliente = c.getCpfCliente();
        this.telefoneCliente = c.getTelefoneCliente();
}
}
