package com.leilao.receita.federal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;

@Embeddable
public class Local {
    @Schema(example = "69")
    private Integer numero;
    @Schema(example = "Rua dos Encanadores")
    private String rua;
    @Schema(example = "São José dos Campos")
    private String cidade;
    @Schema(example = "SP")
    private String estado;

    // Getters e Setters

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
