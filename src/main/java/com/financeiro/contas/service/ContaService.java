package com.financeiro.contas.service;

import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.model.ContaEntity;
import com.financeiro.contas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private ContaRepository contaRepository;


    @Autowired
    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<ContaListaDTO> listarContas(){

       contaRepository.findAll().forEach(contaEntity -> {
           contaEntity.getDataVencimento().
       });
        return null;
    }
}
