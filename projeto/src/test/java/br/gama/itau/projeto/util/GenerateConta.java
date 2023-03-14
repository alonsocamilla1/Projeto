package br.gama.itau.projeto.util;

import br.gama.itau.projeto.model.Conta;

public class GenerateConta {

        public static Conta novaContaToSave() {
        return Conta.builder()
            .agencia(1111)
            .tipoConta(2)
            .saldo(10)
            .build();
    }

    public static Conta contaValida() {
        return Conta.builder()
            .numeroConta(2)
            .agencia(1111)
            .tipoConta(2)
            .saldo(10)
            .build();
    }
}