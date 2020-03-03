package com.financeiro.contas.converter;

import com.financeiro.contas.dto.ContaDTO;
import com.financeiro.contas.model.ContaEntity;
import org.springframework.stereotype.Component;

@Component
public class ContaConverter {

    public ContaEntity convertToEntity(ContaDTO contaDTO) {
      return  ContaEntity.builder()
                .dataPagamento(contaDTO.getDataPagamento())
                .dataVencimento(contaDTO.getDataVencimento())
                .id(contaDTO.getId())
                .nome(contaDTO.getNome())
                .valorOriginal(contaDTO.getValorOriginal())
                .build();
    }

    public ContaDTO convertToDTO(ContaEntity contaEntity){
        return ContaDTO.builder()
                .dataPagamento(contaEntity.getDataPagamento())
                .dataVencimento(contaEntity.getDataVencimento())
                .id(contaEntity.getId())
                .nome(contaEntity.getNome())
                .valorOriginal(contaEntity.getValorOriginal())
                .build();

    }

}
