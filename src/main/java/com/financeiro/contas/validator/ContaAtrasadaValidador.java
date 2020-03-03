package com.financeiro.contas.validator;

import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.model.ContaEntity;
import org.springframework.stereotype.Component;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class ContaAtrasadaValidador {

    public ContaListaDTO verificaContaEstaAtrasada(ContaEntity contaEntity) {
        if (contaEntity.getDataVencimento().isAfter(LocalDate.now())) {
            calculaAtrasos(ChronoUnit.DAYS.between(contaEntity.getDataVencimento(), LocalDate.now()), contaEntity);
        }
        return null;
    }

    private MonetaryAmount calculaAtrasos(Long dias, ContaEntity contaEntity) {
        if (dias > 3 && dias <= 5) {
            return contaEntity.getValorOriginal().add(calculaMulta(3, contaEntity))
                    .add(calculaJuros(0.002, contaEntity, dias));
        } else{
            if(dias > 5) {
                return contaEntity.getValorOriginal().add(calculaMulta(5, contaEntity))
                        .add(calculaJuros(0.003, contaEntity, dias));
            }else {
                return contaEntity.getValorOriginal().add(calculaMulta(2, contaEntity))
                        .add(calculaJuros(0.001, contaEntity, dias));
            }
        }


    }

    private MonetaryAmount calculaMulta(Number multaPercentual, ContaEntity contaEntity) {
        return contaEntity.getValorOriginal().multiply(multaPercentual).divide(100);
    }

    private MonetaryAmount calculaJuros(Number jurosAoDia, ContaEntity contaEntity, Long dias) {
        return contaEntity.getValorOriginal().multiply(jurosAoDia).multiply(dias);
    }
}
