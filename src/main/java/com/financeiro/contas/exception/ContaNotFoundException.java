package com.financeiro.contas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ContaNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ContaNotFoundException() {
        super("Não existe nenhuma conta cadastrada no banco de dados");
    }
}
