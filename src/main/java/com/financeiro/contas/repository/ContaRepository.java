package com.financeiro.contas.repository;

import com.financeiro.contas.model.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {
}
