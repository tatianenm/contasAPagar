package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
public class Superior5DiasAtraso implements CalculaAtrasosInterface {

    @Override
    public BigDecimal calculaAtrasos(ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().add(calculaMulta((double) 5, contaEntity))
                .add(calculaJuros(0.003, contaEntity, dias));
    }

    private BigDecimal calculaMulta(Double multaPercentual, ContaEntity contaEntity) {
        return contaEntity.getValorOriginal().multiply(new BigDecimal(multaPercentual)).divide(new BigDecimal(100));
    }

    private BigDecimal calculaJuros(Double jurosAoDia, ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().multiply(new BigDecimal(jurosAoDia)).multiply(new BigDecimal(dias));
    }
}
