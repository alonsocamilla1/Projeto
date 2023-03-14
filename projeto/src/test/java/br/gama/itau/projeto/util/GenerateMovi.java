package br.gama.itau.projeto.util;

import java.time.LocalDate;

import br.gama.itau.projeto.model.Movimentacao;

public class GenerateMovi {

    public static Movimentacao novaMoviToSave() {
        return Movimentacao.builder()
            .dataOperacao(LocalDate.now())
            .valor(1)
            .tipoOperacao(1)
            .build();
    }

    public static Movimentacao moviValida() {
        return Movimentacao.builder()
            .numSeq(1)
            .dataOperacao(LocalDate.now())
            .valor(1)
            .tipoOperacao(1)
            .build();
    
}
}
