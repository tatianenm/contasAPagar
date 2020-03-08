package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;

import java.math.BigDecimal;

public class Ate3DiasAtraso implements CalculaAtrasosInterface {

    @Override
    public BigDecimal calculaAtrasos(ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().add(calculaMulta((double) 2, contaEntity))
                .add(calculaJuros(0.001, contaEntity, dias));
    }

    private BigDecimal calculaMulta(Double multaPercentual, ContaEntity contaEntity) {
        return contaEntity.getValorOriginal().multiply(new BigDecimal(multaPercentual)).divide(new BigDecimal(100));
    }

    private BigDecimal calculaJuros(Double jurosAoDia, ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().multiply(new BigDecimal(jurosAoDia)).multiply(new BigDecimal(dias));
    }
}
