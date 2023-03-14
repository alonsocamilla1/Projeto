package br.gama.itau.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
public class Cliente {
    
    // Modelo de dados do Cliente
    // Cria uma tabela Cliente com Id, nome, cpf e telefone
    // O Id é incrementado automaticamente a cada cliente criado
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100)
    private String nomeCliente;

    @Column(length = 20, unique = true)
    private String cpfCliente;

    @Column(length = 20, unique = true)
    private String telefoneCliente;
}

