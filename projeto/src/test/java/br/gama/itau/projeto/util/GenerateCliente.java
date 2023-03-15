package br.gama.itau.projeto.util;

import br.gama.itau.projeto.Model.Cliente;

public class GenerateCliente {
    

    public static Cliente novoClienteToSave() {
        return Cliente.builder()
            .nomeCliente("AAA")
            .cpfCliente("1111")
            .telefoneCliente("11111")
            .build();
    }

    public static Cliente clienteValido() {
        return Cliente.builder()
            .idCliente(1)
            .nomeCliente("AAA")
            .cpfCliente("1111")
            .telefoneCliente("11111")
            .build();
    }
}
