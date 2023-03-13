package br.gama.itau.projeto.Model;

import java.sql.Date;

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
    private Long numSeq;
    private Date dataOperacao;
    private Double valor;
    private Integer tipoOperacao;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "numero_conta")
    private Conta conta;
}
