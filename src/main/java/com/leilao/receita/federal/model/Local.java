package com.leilao.receita.federal.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Local {

    private Integer numero;
    private String rua;
    private String cidade;
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
