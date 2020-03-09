package com.financeiro.contas.service;

import com.financeiro.contas.converter.ContaConverter;
import com.financeiro.contas.dto.ContaDTO;
import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.exception.ContaNotFoundException;
import com.financeiro.contas.factory.CalculaAtrasosFactory;
import com.financeiro.contas.model.ContaEntity;
import com.financeiro.contas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        this.calculaAtrasosFactory = calculaAtrasosFactory;
    }

    public List<ContaListaDTO> listarContas() {
        var listaContaEntity = contaRepository.findAll();
        if (Objects.isNull(listaContaEntity)) {
            throw new ContaNotFoundException();
        }
        return listaContaEntity
                .stream()
                .map(this::verificaContasAtrasadasEAtualizaJuroMultaNoBancoDados)
                .map(contaConverter::convertToContaListaDTO)
                .collect(Collectors.toList());
    }

    public ContaEntity salvarCadastro(ContaDTO contaDTO) {
        contaDTO.setId(null);
        return contaRepository.save(contaConverter.convertToEntity(contaDTO));
    }

    private ContaEntity verificaContasAtrasadasEAtualizaJuroMultaNoBancoDados(ContaEntity contaEntity) {
        if (LocalDate.now().isAfter(contaEntity.getDataVencimento())) {
            var dias = ChronoUnit.DAYS.between(contaEntity.getDataVencimento(), LocalDate.now());
            contaEntity.setQuantddDiasAtraso(dias);
            contaEntity.setValorCorrigido(calculaAtrasosFactory
                    .calculaContasAtrasadas(contaEntity, dias).setScale(2, RoundingMode.HALF_EVEN));
            contaRepository.save(contaEntity);
        }
        return contaEntity;
    }

}
