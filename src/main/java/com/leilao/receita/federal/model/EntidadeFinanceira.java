package com.leilao.receita.federal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class EntidadeFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Schema(example = "Banco do Brasil")
    private String nomeEntidade;
    @Schema(example = "00.000.000/0001-91")
    private String cnpj;

    public String getNomeEntidade() {
        return nomeEntidade;
    }

    public void setNomeEntidade(String nomeEntidade) {
        this.nomeEntidade = nomeEntidade;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
