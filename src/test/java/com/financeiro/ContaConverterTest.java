package com.financeiro;

import com.financeiro.contas.converter.ContaConverter;
import com.financeiro.contas.dto.ContaDTO;
import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.model.ContaEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ContaConverterTest {

    private static final Long ID = 2L;

    private static final String NOME = "Susi";

    private static final Long DIAS_EM_ATRASO = 2L;

    private static final BigDecimal VALOR_CORRIGIDO = new BigDecimal(1586.35);

    private static final BigDecimal VALOR_ORIGINAL = new BigDecimal(586.75);

    private static final LocalDate DATA_PAGAMENTO = LocalDate.now();

    private static final LocalDate DATA_VENCIMENTO = LocalDate.now();

    @InjectMocks
    private ContaConverter contaConverter;

    @Test
    public void deveConverterToContaEntity() {
        ContaDTO contaDTO = ContaDTO.builder()
                .id(ID)
                .nome(NOME)
                .valorOriginal(VALOR_ORIGINAL)
                .dataPagamento(DATA_PAGAMENTO)
                .dataVencimento(DATA_VENCIMENTO)
                .build();

        ContaEntity contaEntity = contaConverter.convertToEntity(contaDTO);

        assertNotNull(contaEntity);
        assertEquals(contaEntity.getId(), contaDTO.getId());
        assertEquals(contaEntity.getNome(), contaDTO.getNome());
        assertEquals(contaEntity.getValorOriginal(), contaDTO.getValorOriginal());
        assertEquals(contaEntity.getDataVencimento(), contaDTO.getDataVencimento());
        assertEquals(contaEntity.getDataPagamento(), contaDTO.getDataPagamento());
    }

    @Test
    public void deveConverterToContaDTO() {
        ContaEntity contaEntity = ContaEntity.builder()
                .id(ID)
                .dataPagamento(DATA_PAGAMENTO)
                .dataVencimento(DATA_VENCIMENTO)
                .nome(NOME)
                .valorOriginal(VALOR_ORIGINAL)
                .build();

        ContaDTO contaDTO = contaConverter.convertToDTO(contaEntity);

        assertNotNull(contaDTO);
        assertEquals(contaDTO.getId(), contaEntity.getId());
        assertEquals(contaDTO.getNome(), contaEntity.getNome());
        assertEquals(contaDTO.getValorOriginal(), contaEntity.getValorOriginal());
        assertEquals(contaDTO.getDataVencimento(), contaEntity.getDataVencimento());
        assertEquals(contaDTO.getDataPagamento(), contaEntity.getDataPagamento());
    }

    @Test
    public void deveConverterToContaListaDTO() {
        ContaEntity contaEntity = ContaEntity.builder()
                .id(ID)
                .dataPagamento(DATA_PAGAMENTO)
                .quantddDiasAtraso(DIAS_EM_ATRASO)
                .valorCorrigido(VALOR_CORRIGIDO)
                .nome(NOME)
                .valorOriginal(VALOR_ORIGINAL)
                .build();

        ContaListaDTO contaListaDTO = contaConverter.convertToContaListaDTO(contaEntity);

        assertNotNull(contaListaDTO);
        assertEquals(contaListaDTO.getId(), contaEntity.getId());
        assertEquals(contaListaDTO.getNome(), contaEntity.getNome());
        assertEquals(contaListaDTO.getValorOriginal(), contaEntity.getValorOriginal());
        assertEquals(contaListaDTO.getDataPagamento(), contaEntity.getDataPagamento());
        assertEquals(contaListaDTO.getQtdDiasAtraso(), contaEntity.getQuantddDiasAtraso());
        assertEquals(contaListaDTO.getValorCorrigido(), contaEntity.getValorCorrigido());
    }


}
