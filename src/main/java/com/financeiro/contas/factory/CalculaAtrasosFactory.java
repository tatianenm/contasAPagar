package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CalculaAtrasosFactory {

    private final Ate3DiasAtraso ate3DiasAtraso;

    private final Superior3DiasAtraso superior3DiasAtraso;

    private final Superior5DiasAtraso superior5DiasAtraso;

    public BigDecimal calculaContasAtrasadas(ContaEntity contaEntity, Long dias) {
        if (dias <= 3) {
            return ate3DiasAtraso.calculaAtrasos(contaEntity, dias);
        } else if (dias > 3 && dias <= 5) {
            return superior3DiasAtraso.calculaAtrasos(contaEntity, dias);
        } else if (dias > 5) {
            return superior5DiasAtraso.calculaAtrasos(contaEntity, dias);
        }
        return null;
    }
}
