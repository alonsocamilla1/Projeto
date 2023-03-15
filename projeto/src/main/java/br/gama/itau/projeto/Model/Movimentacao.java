package br.gama.itau.projeto.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movimentacao {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numSeq;

    private LocalDate dataOperacao;
    private Double valor;
    private Integer tipoOperacao;
    private String descricao;

    @ManyToOne
    @JsonIgnoreProperties("movimentacoes")
    @JoinColumn(name = "numero_conta")
    private Conta conta;
}
