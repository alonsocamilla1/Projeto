package br.gama.itau.projeto.service;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

//import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

//import br.gama.itau.projeto.exception.NotFoundException;
import br.gama.itau.projeto.model.Movimentacao;
import br.gama.itau.projeto.repositorio.MovimentacaoRepo;
import br.gama.itau.projeto.util.GenerateMovi;

@ExtendWith(MockitoExtension.class)
public class MovimentacaoServiceTest {

    @InjectMocks
    private MovimentacaoService service;

    @Mock
    private MovimentacaoRepo repo;

    @Test
    public void cadastrarMovimentacao_returnMovimentacaoCadastrada_whenMovimentacaoExist() {
         BDDMockito.when(repo.save(ArgumentMatchers.any(Movimentacao.class)))
                    .thenReturn(GenerateMovi.moviValida());

            Movimentacao novaMovi = GenerateMovi.novaMoviToSave();

            Movimentacao moviCadastrada = service.cadastrarMovimentacao(novaMovi);

            assertThat(moviCadastrada).isNotNull();
            assertThat(moviCadastrada.getNumSeq()).isPositive();
            assertThat(moviCadastrada.getValor()).isEqualTo(novaMovi.getValor());

            verify(repo, Mockito.times(1)).save(novaMovi);
    }

    @Test
    public void cadastrarMovimentacao_returnNull_whenMovimentacaoNotExist() {
        Movimentacao novaMovi = GenerateMovi.moviValida();

        Movimentacao moviCadastrada = service.cadastrarMovimentacao(novaMovi);

        assertThat(moviCadastrada).isNull();

        verify(repo, Mockito.times(0)).save(novaMovi);
    }
   
    
    @Test
    public void recuperarTodas_returnTodasAsMovimentacoesCadastradas_whenSucesso () {
        BDDMockito.when(repo.save(ArgumentMatchers.any(Movimentacao.class)))
                    .thenReturn(GenerateMovi.moviValida());

    }
}

