package com.financeiro.contas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty("dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;

}
