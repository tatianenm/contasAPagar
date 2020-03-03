package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculaAtrasosFactory {

    private Ate3DiasAtraso ate3DiasAtraso;

    private Superior3DiasAtraso superior3DiasAtraso;

    private Superior5DiasAtraso superior5DiasAtraso;


    @Autowired
    public CalculaAtrasosFactory(Ate3DiasAtraso ate3DiasAtraso, Superior3DiasAtraso superior3DiasAtraso,
                                 Superior5DiasAtraso superior5DiasAtraso) {
        this.ate3DiasAtraso = ate3DiasAtraso;
        this.superior3DiasAtraso = superior3DiasAtraso;
        this.superior5DiasAtraso = superior5DiasAtraso;
    }

    public MonetaryAmount getContasAtrasadas(ContaEntity contaEntity) {
        if (contaEntity.getDataVencimento().isAfter(LocalDate.now())) {
            var dias = ChronoUnit.DAYS.between(contaEntity.getDataVencimento(), LocalDate.now());
            if (dias <= 3) {
                return ate3DiasAtraso.calculaAtrasos(contaEntity, dias);
            } else if (dias > 3 && dias <= 5) {
               // return new Superior3DiasAtraso(contaEntity, dias);
            } else if (dias > 5) {
               // return new Superior5DiasAtraso(contaEntity, dias);
            }
        }
        return null;
    }
}
