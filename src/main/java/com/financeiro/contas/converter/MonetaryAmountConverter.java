package com.financeiro.contas.converter;

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.math.BigDecimal;
import java.util.Locale;

@Converter
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, BigDecimal> {
    @Override
    public BigDecimal convertToDatabaseColumn(MonetaryAmount monetaryAmount) {

        return new BigDecimal(String.valueOf(monetaryAmount.getNumber()));
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(BigDecimal bigDecimal) {
//        MonetaryAmount valorEmReais = MonetaryAmounts.getDefaultAmountFactory()
//                .setNumber(bigDecimal)
//                .setCurrency("BRL")
//                .create();
        return null;
    }
}
