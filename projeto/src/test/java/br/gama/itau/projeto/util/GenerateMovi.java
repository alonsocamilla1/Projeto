package br.gama.itau.projeto.util;

import br.gama.itau.projeto.Model.Movimentacao;
import java.time.LocalDate;

public class GenerateMovi {
    public static Movimentacao novaMoviToSave() {
        return Movimentacao.builder()
            .dataOperacao(LocalDate.now())
            .valor(1.0)
            .tipoOperacao(1)
            .build();
    }

    public static Movimentacao moviValida() {
        return Movimentacao.builder()
            .numSeq(1)
            .dataOperacao(LocalDate.now())
            .valor(1.0)
            .tipoOperacao(1)
            .build();
    
}
}
