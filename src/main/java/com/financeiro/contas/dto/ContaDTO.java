package com.financeiro.contas.dto;

import lombok.*;

import javax.money.MonetaryAmount;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    private Long id;

    private String nome;

    private MonetaryAmount valorOriginal;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;
}
