package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;

import javax.money.MonetaryAmount;

public class Superior5DiasAtraso implements CalculaAtrasosInterface {

    @Override
    public MonetaryAmount calculaAtrasos(ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().add(calculaMulta(5, contaEntity))
                .add(calculaJuros(0.003, contaEntity, dias));
    }

    private MonetaryAmount calculaMulta(Number multaPercentual, ContaEntity contaEntity) {
        return contaEntity.getValorOriginal().multiply(multaPercentual).divide(100);
    }

    private MonetaryAmount calculaJuros(Number jurosAoDia, ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().multiply(jurosAoDia).multiply(dias);
    }
}
