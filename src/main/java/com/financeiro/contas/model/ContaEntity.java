package com.financeiro.contas.model;

import lombok.*;

import javax.money.MonetaryAmount;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Table(name = "conta")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContaEntity implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private MonetaryAmount valorOriginal;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

}
