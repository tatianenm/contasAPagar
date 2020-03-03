package com.financeiro.contas.service;

import com.financeiro.contas.converter.ContaConverter;
import com.financeiro.contas.dto.ContaDTO;
import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.factory.CalculaAtrasosFactory;
import com.financeiro.contas.model.ContaEntity;
import com.financeiro.contas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private ContaRepository contaRepository;

    private CalculaAtrasosFactory calculaAtrasosFactory;

    private ContaConverter contaConverter;


    @Autowired
    public ContaService(ContaRepository contaRepository, CalculaAtrasosFactory calculaAtrasosFactory,
                        ContaConverter contaConverter) {
        this.contaRepository = contaRepository;
        this.contaConverter = contaConverter;
    }

    public List<ContaListaDTO> listarContas() {
        contaRepository.findAll().forEach(this::validaContasAtrasadas);
        return null;
    }

    public ContaEntity salvarCadastro(ContaDTO contaDTO) {
        return contaRepository.save(contaConverter.convertToEntity(contaDTO));
    }

    private ContaEntity validaContasAtrasadas(ContaEntity conta) {
        calculaAtrasosFactory.getContasAtrasadas(conta);
    }
}
