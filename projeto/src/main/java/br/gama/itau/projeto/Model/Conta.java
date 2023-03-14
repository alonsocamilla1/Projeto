package br.gama.itau.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
public class Conta {
   
    // Modelo de dados da Conta
    // Cria uma tabela Conta com número, agência, tipo, saldo e id do cliente
    // O número da conta (numeroConta) é incrementado automaticamente a cada conta criada
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroConta;
    private int agencia;
    private int tipoConta;
    private double saldo;

   // O idCliente é uma coluna de relacionamento N:1 da tabela Conta com Cliente, pegando a chave estrangeira
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

}
