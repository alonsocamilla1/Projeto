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
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int numSeq;
   
    private Date dataOperacao;
    private double valor;
    private int tipoOperacao;
   
    @Column(length = 255)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "numeroConta")
    private Conta numerConta;
}
