package com.financeiro.contas.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContaListaDTO {

    private Long id;

    private String nome;

    private BigDecimal valorOriginal;

    private BigDecimal valorCorrigido;

    private Long qtdDiasAtraso;

    private LocalDate dataPagamento;

}
