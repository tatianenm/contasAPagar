package com.financeiro.contas.dto;

import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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

    private Long qtdDiasAtraso;

    private LocalDate dataPagamento;

}
