package br.gama.itau.projeto.DTO;

import br.gama.itau.projeto.Model.Cliente;

public class ClienteDTO {
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