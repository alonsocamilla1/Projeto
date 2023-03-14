package br.gama.itau.projeto.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Movimentacao {
    
    // Modelo de dados da Movimentação
    // Cria uma tabela Movimentação com número, data da operação, valor, tipo de operação, descrição e número da conta
    // O número (numSeq) é incrementado automaticamente a cada movimentação criada
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int numSeq;
   
    private Date dataOperacao;
    private double valor;
    private int tipoOperacao;
   
    @Column(length = 255)
    private String descricao;
    
    // A conta é uma coluna de relacionamento N:1 da tabela Movimentação com Conta, pegando a chave estrangeira
    @ManyToOne
    @JoinColumn(name = "numeroConta")
    private Conta numerConta;
}
