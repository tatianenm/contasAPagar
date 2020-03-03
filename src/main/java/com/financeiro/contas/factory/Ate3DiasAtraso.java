package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.money.MonetaryAmount;

public class Ate3DiasAtraso implements CalculaAtrasos {

    private ContaEntity contaEntity;

    private Long dias;

    @Autowired
    public Ate3DiasAtraso(ContaEntity contaEntity, Long dias) {
        this.contaEntity = contaEntity;
        this.dias = dias;
    }


    @Override
    public MonetaryAmount calculaAtrasos() {
        return  contaEntity.getValorOriginal().add(calculaMulta(2, contaEntity))
                       .add(calculaJuros(0.001, contaEntity, dias));
    }

    private MonetaryAmount calculaMulta(Number multaPercentual, ContaEntity contaEntity) {
        return contaEntity.getValorOriginal().multiply(multaPercentual).divide(100);
    }

    private MonetaryAmount calculaJuros(Number jurosAoDia, ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().multiply(jurosAoDia).multiply(dias);
    }
}
