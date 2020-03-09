package com.financeiro;

import com.financeiro.contas.converter.ContaConverter;
import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.factory.CalculaAtrasosFactory;
import com.financeiro.contas.model.ContaEntity;
import com.financeiro.contas.repository.ContaRepository;
import com.financeiro.contas.service.ContaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ContaServiceTest {

    private static final Long ID = 2L;

    private static final String NOME = "Susi";

    private static final Long DIAS_EM_ATRASO = 30L;

    private static final BigDecimal VALOR_CORRIGIDO = new BigDecimal(1586.35);

    private static final BigDecimal VALOR_ORIGINAL = new BigDecimal(586.12);

    private static final LocalDate DATA_PAGAMENTO = LocalDate.now();

    private static final LocalDate DATA_VENCIMENTO = LocalDate.now();

    @InjectMocks
    private ContaService contaService;
    @Mock
    private CalculaAtrasosFactory calculaAtrasosFactory;
    @Mock
    private ContaConverter contaConverter;
    @Mock
    private ContaRepository contaRepository;

    @Test
    public void deveListarTodasContasBanco() {
        when(contaRepository.findAll()).thenReturn(Arrays.asList(mockContaEntity()));
        when(contaConverter.convertToContaListaDTO(mockContaEntity())).thenReturn(mockContaListaDTO());

        List<ContaListaDTO> contaListaDTOS = contaService.listarContas();

        assertEquals(ID, contaListaDTOS.get(0).getId());
        assertEquals(NOME, contaListaDTOS.get(0).getNome());
        assertEquals(VALOR_CORRIGIDO, contaListaDTOS.get(0).getValorCorrigido());
    }

    private ContaEntity mockContaEntity() {
        ContaEntity contaEntity = new ContaEntity();
        contaEntity.setId(ID);
        contaEntity.setNome(NOME);
        contaEntity.setDataVencimento(DATA_VENCIMENTO);
        contaEntity.setValorOriginal(VALOR_ORIGINAL);
        return contaEntity;
    }

    private ContaListaDTO mockContaListaDTO() {
        return ContaListaDTO.builder()
                .id(ID)
                .nome(NOME)
                .dataPagamento(DATA_PAGAMENTO)
                .qtdDiasAtraso(DIAS_EM_ATRASO)
                .valorCorrigido(VALOR_CORRIGIDO)
                .valorOriginal(VALOR_ORIGINAL)
                .build();
    }

}
