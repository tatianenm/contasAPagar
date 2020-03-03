package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.money.MonetaryAmount;

public class Superior5DiasAtraso implements CalculaAtrasosInterface {

    private ContaEntity contaEntity;

    private Long dias;

    @Autowired
    public Superior5DiasAtraso(ContaEntity contaEntity, Long dias) {
        this.contaEntity = contaEntity;
        this.dias = dias;
    }

    @Override
    public MonetaryAmount calculaAtrasos() {
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
