package com.financeiro.contas.model;

import lombok.Setter;
import lombok.Getter;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.money.MonetaryAmount;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "conta")
public class ContaEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "valororiginal")
    private MonetaryAmount valorOriginal;

    @NotNull
    @Column(name = "datavencimento")
    private LocalDate dataVencimento;

    @Column(name = "datapagamento")
    private LocalDate dataPagamento;

    @Column(name = "valorcorrigido ")
    private MonetaryAmount valorCorrigido;

    @Column(name = "quantddDiasAtraso")
    private Long quantddDiasAtraso;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContaEntity)) return false;
        ContaEntity that = (ContaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(valorOriginal, that.valorOriginal) &&
                Objects.equals(dataVencimento, that.dataVencimento) &&
                Objects.equals(dataPagamento, that.dataPagamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
