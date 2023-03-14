package br.gama.itau.projeto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gama.itau.projeto.exception.NotFoundException;
import br.gama.itau.projeto.model.Conta;
import br.gama.itau.projeto.repositorio.ContaRepo;
import br.gama.itau.projeto.util.GenerateConta;

@ExtendWith(MockitoExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService service;

    @Mock
    private ContaRepo repo;

    @Test
    public void novaConta_returnAdicionarConta_whenContaValida() {
        BDDMockito.when(repo.save(ArgumentMatchers.any(Conta.class)))
                .thenReturn(GenerateConta.contaValida());

        Conta novaConta = GenerateConta.novaContaToSave();

        Conta contaCriada = service.adicionarConta(novaConta);

        assertThat(contaCriada).isNotNull();
        assertThat(contaCriada.getNumeroConta()).isPositive();
        assertThat(contaCriada.getId()).isEqualTo(novaConta.getId());

        // verifica se o método save foi chamado 1 vez
        verify(repo, Mockito.times(1)).save(novaConta);
    }

    @Test
    public void recuperarPeloNumero_returnConta_whenNumeroExist() {
        BDDMockito.when(repo.findById(ArgumentMatchers.any(int.class)))
                .thenReturn(Optional.of(GenerateConta.contaValida()));

        Conta contaEncontrada = service.recuperarPeloNumero(2);

        assertThat(contaEncontrada).isNotNull();
        assertThat(contaEncontrada.getNumeroConta()).isGreaterThan(0);
        assertThat(contaEncontrada.getNumeroConta())
                .isEqualTo(GenerateConta.contaValida()
                .getNumeroConta());
    }

    @Test
    public void recuperarPeloNumero_throwException_whenNumeroNotExist() {
        Conta contaValida = GenerateConta.novaContaToSave();

        // verifica se uma exception do tipo NotFoundException é lançada
        assertThrows(NotFoundException.class, () -> {
            service.recuperarPeloNumero(contaValida.getNumeroConta());
        });
    }


    
}
