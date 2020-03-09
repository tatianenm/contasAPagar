package com.financeiro.contas.converter;

import com.financeiro.contas.dto.ContaDTO;
import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.model.ContaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ContaConverter {

    public ContaEntity convertToEntity(ContaDTO contaDTO) {
        return ContaEntity.builder()
                .dataPagamento(contaDTO.getDataPagamento())
                .dataVencimento(contaDTO.getDataVencimento())
                .id(contaDTO.getId())
                .nome(contaDTO.getNome())
                .valorOriginal(contaDTO.getValorOriginal())
                .build();
    }

    public ContaDTO convertToDTO(ContaEntity contaEntity) {
        return ContaDTO.builder()
                .dataPagamento(contaEntity.getDataPagamento())
                .dataVencimento(contaEntity.getDataVencimento())
                .id(contaEntity.getId())
                .nome(contaEntity.getNome())
                .valorOriginal(contaEntity.getValorOriginal())
                .build();

    }

    public ContaListaDTO convertToContaListaDTO(ContaEntity contaEntity) {
        return ContaListaDTO.builder()
                .dataPagamento(LocalDate.now())
                .id(contaEntity.getId())
                .nome(contaEntity.getNome())
                .qtdDiasAtraso(contaEntity.getQuantddDiasAtraso())
                .valorCorrigido(contaEntity.getValorCorrigido())
                .valorOriginal(contaEntity.getValorOriginal())
                .build();
    }

}
