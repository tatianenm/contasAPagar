package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculaAtrasosFactory {

    public CalculaAtrasos getContasAtrasadas(ContaEntity contaEntity) {
        if (contaEntity.getDataVencimento().isAfter(LocalDate.now())) {
            var dias = ChronoUnit.DAYS.between(contaEntity.getDataVencimento(), LocalDate.now());
            if (dias <= 3) {
                return new Ate3DiasAtraso(contaEntity, dias);
            } else if (dias > 3 && dias <= 5) {
                return new Superior3DiasAtraso(contaEntity, dias);
            } else if (dias > 5) {
                return new Superior5DiasAtraso(contaEntity, dias);
            }
        }
        return null;
    }
}
