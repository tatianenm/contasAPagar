package com.financeiro.contas.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    private Long id;

    private String nome;

    private BigDecimal valorOriginal;

    private LocalDate dataVencimento;

    private LocalDate dataPagamento;
}
