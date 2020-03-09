package com.financeiro.contas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContaDTO {

    @ApiModelProperty(hidden = true)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private BigDecimal valorOriginal;

    @ApiModelProperty(example = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dataVencimento;

    @ApiModelProperty(example = "dd/MM/yyyy")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dataPagamento;
}
