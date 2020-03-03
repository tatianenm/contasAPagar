package com.financeiro.contas.factory;

import com.financeiro.contas.model.ContaEntity;

import javax.money.MonetaryAmount;

public interface CalculaAtrasosInterface {

    public MonetaryAmount calculaAtrasos(ContaEntity contaEntity, Long dias);
}
