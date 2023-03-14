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
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numeroConta;
    private int agencia;
    private int tipoConta;
    private double saldo;
    private int id;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

}
