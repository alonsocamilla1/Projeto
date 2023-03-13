package br.gama.itau.projeto.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(length = 100, nullable = false)
    private String nomeCliente;

    @Column(length = 20, nullable = false, unique = true)
    private String cpfCliente;

    @Column(length = 20, nullable = false, unique = true)
    private String telefoneCliente;
}

