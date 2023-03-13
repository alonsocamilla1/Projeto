package br.gama.itau.projeto.model;

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
<<<<<<< HEAD
    private int numeroConta;
=======
    private long numeroConta;
>>>>>>> af72bee43934da1048bfe21338569c975cb6adf0
    private int agencia;
    private int tipoConta;
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
}
