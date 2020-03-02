package com.financeiro.contas.dto;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

public class ContaDTO {

    private Long id;

    private String nome;

    private MonetaryAmount valorOriginal;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;
}
