package com.financeiro.contas.controller;

import com.financeiro.contas.dto.ContaDTO;
import com.financeiro.contas.dto.ContaListaDTO;
import com.financeiro.contas.service.ContaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "API Contas a Pagar")
@RequestMapping("contas/v1")
@RestController
public class ContaController {

    private ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }


    @GetMapping
    public List<ContaListaDTO> listarContas() {
        return contaService.listarContas();
    }

    @ApiOperation(value = "Cadastro de protocolos")
    @PostMapping(consumes = {APPLICATION_JSON_VALUE},
            produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<ContaDTO> cadastrar(@RequestBody @Valid ContaDTO contaDTO
     UriComponentsBuilder uriBuilder) {

    }
}
