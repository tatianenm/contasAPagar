package com.financeiro.contas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContaListaDTO {

    @ApiModelProperty(hidden = true)
    private Long id;

    private String nome;

    @ApiModelProperty(example = "R$ ###.###,##")
    private BigDecimal valorOriginal;

    @ApiModelProperty(example = "R$ ###.###,##")
    private BigDecimal valorCorrigido;

    private Long qtdDiasAtraso;

    @ApiModelProperty(example = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;

}
