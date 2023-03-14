package br.gama.itau.projeto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gama.itau.projeto.model.Cliente;
import br.gama.itau.projeto.repositorio.ClienteRepo;
import br.gama.itau.projeto.util.GenerateCliente;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {
    
    @InjectMocks
    private ClienteService service;

    @Mock
    private ClienteRepo repo;

    @Test
    public void novoCliente_returnCadastrarCliente_whenClienteValido() {
        // preparação
        BDDMockito.when(repo.save(ArgumentMatchers.any(Cliente.class)))
                .thenReturn(GenerateCliente.clienteValido());

        Cliente novoCliente = GenerateCliente.novoClienteToSave();

        // ação
        Cliente clienteCriado = service.cadastrarCliente(novoCliente);

        // verificação
        assertThat(clienteCriado).isNotNull();
        assertThat(clienteCriado.getId()).isPositive();
        assertThat(clienteCriado.getCpfCliente()).isEqualTo(novoCliente.getCpfCliente());

        // verifica se o método save foi chamado 1 vez
        verify(repo, Mockito.times(1)).save(novoCliente);
    }

}
