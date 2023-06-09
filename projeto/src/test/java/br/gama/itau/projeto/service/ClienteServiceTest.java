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

import br.gama.itau.projeto.util.*;
import br.gama.itau.projeto.exception.*;
import br.gama.itau.projeto.model.*;
import br.gama.itau.projeto.repositorio.*;
import br.gama.itau.projeto.service.*;
@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
private ClienteService service;
@Mock
private ClienteRepo repo;
@Test
public void novoCliente_returnCadastrarCliente_whenClienteValido() {
    BDDMockito.when(repo.save(ArgumentMatchers.any(Cliente.class)))
            .thenReturn(GenerateCliente.clienteValido());
    Cliente novoCliente = GenerateCliente.novoClienteToSave();
    Cliente clienteCriado = service.cadastrarCliente(novoCliente);
    assertThat(clienteCriado).isNotNull();
    assertThat(clienteCriado.getIdCliente()).isPositive();
    assertThat(clienteCriado.getIdCliente()).isEqualTo(GenerateCliente.clienteValido().getIdCliente());
    // verifica se o método save foi chamado 1 vez
    verify(repo, Mockito.times(1)).save(novoCliente);
}
@Test
public void novoCliente_returnNull_whenClienteInvalido() {
   Cliente clienteValido = GenerateCliente.clienteValido();
    Cliente clienteRetornado = service.cadastrarCliente(clienteValido);
    assertThat(clienteRetornado).isNull();
    // verifica que o método save não foi chamado
    verify(repo, Mockito.times(1)).save(clienteValido);
}
@Test
public void recuperarPeloId_returnCliente_whenIdExist() {
    BDDMockito.when(repo.findById(ArgumentMatchers.any(int.class)))
            .thenReturn(Optional.of(GenerateCliente.clienteValido()));
    Cliente clienteEncontrado = service.recuperarPeloID(1);
    assertThat(clienteEncontrado)
            .isNotNull();
    assertThat(clienteEncontrado.getIdCliente())
            .isGreaterThan(0);
    assertThat(clienteEncontrado.getIdCliente())
            .isEqualTo(GenerateCliente.clienteValido().getIdCliente())
            .isNotNull();
}
@Test
public void recuperarPeloId_throwException_whenIdNotExist() {
    Cliente clienteValido = GenerateCliente.novoClienteToSave();
    // verifica se uma exception do tipo NotFoundException é lançada
    // () -> { } é uma chamada de método anônimo
    assertThrows(NotFoundException.class, () -> {
        service.recuperarPeloID(clienteValido.getIdCliente());
    });
}
    
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
