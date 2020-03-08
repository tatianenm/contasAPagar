package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class Ate3DiasAtraso implements CalculaAtrasosInterface {

    @Override
    public BigDecimal calculaAtrasos(ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().add(calculaMulta((double) 2, contaEntity))
                .add(calculaJuros(0.001, contaEntity, dias));
    }

    private BigDecimal calculaMulta(Double multaPercentual, ContaEntity contaEntity) {
        return contaEntity.getValorOriginal().multiply(new BigDecimal(multaPercentual))
                .divide(new BigDecimal(100), 2, RoundingMode.HALF_EVEN);
    }

    private BigDecimal calculaJuros(Double jurosAoDia, ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().multiply(new BigDecimal(jurosAoDia)).multiply(new BigDecimal(dias));
    }
}
