package br.gama.itau.projeto.Model;

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
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numeroConta;
    private int agencia;
    private int tipoConta;
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
}
