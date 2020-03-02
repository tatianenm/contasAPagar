package com.financeiro.contas.service;

import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.model.ContaEntity;
import com.financeiro.contas.repository.ContaRepository;
import com.financeiro.contas.validator.ContaAtrasadaValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private ContaRepository contaRepository;

    private ContaAtrasadaValidador contaValidador;


    @Autowired
    public ContaService(ContaRepository contaRepository, ContaAtrasadaValidador contaValidador) {
        this.contaRepository = contaRepository;
        this.contaValidador = contaValidador;
    }

    public List<ContaListaDTO> listarContas(){

       contaRepository.findAll().forEach(conta -> {
        contaValidador.verificaContaEstaAtrasada(conta);
       });
    }
}
