package com.financeiro.contas.dto;

import lombok.*;

import javax.money.MonetaryAmount;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContaListaDTO {

    private Long id;

    private String nome;

    private MonetaryAmount valorOriginal;

    private MonetaryAmount valorCorrigido;

    private Integer qtdDiasAtraso;

    private LocalDate dataPagamento;

}
