package com.financeiro.contas.repository;

import com.financeiro.contas.model.ContaEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<ContaEntity, Long> {
}
