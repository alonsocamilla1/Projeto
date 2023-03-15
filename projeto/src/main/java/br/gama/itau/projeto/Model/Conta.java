package br.gama.itau.projeto.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Conta {

    // Modelo de dados da Conta
    // Cria uma tabela Conta com número, agência, tipo, saldo e id do cliente
    // O número da conta (numeroConta) é incrementado automaticamente a cada conta
    // criada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroConta;

    private Integer agencia;
    private Integer tipoConta;
    private Double saldo;

    // O idCliente é uma coluna de relacionamento N:1 da tabela Conta com Cliente,
    // pegando a chave estrangeira
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

}
