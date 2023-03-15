package br.gama.itau.projeto.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import br.gama.itau.projeto.Model.*;
import br.gama.itau.projeto.util.*;
import br.gama.itau.projeto.Repositorio.*;

@DataJpaTest
public class ClienteRepoTest {

    @Autowired
    private ClienteRepo repo;

}
