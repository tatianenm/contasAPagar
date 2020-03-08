package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


public interface CalculaAtrasosInterface {

    public BigDecimal calculaAtrasos(ContaEntity contaEntity, Long dias);
}
