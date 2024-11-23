package com.leilao.receita.federal.model;

import com.leilao.receita.federal.enums.StatusDoProduto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Informatica {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(hidden = true)
    private Long id;

    @Schema(example = "Iphone 13")
    private String nomeProduto;

    @Schema(example = "Apple")
    private String marca;

    @Schema(example = "Iphone 13")
    private String modelo;

    @Schema(example = "Ótimo")
    private String conservacao;

    @Schema(example = "IOS 18, 4GB RAM, saúde da bateria 90% ")
    private String especificacoesTecnicas;

    @Schema(example = "1000.00")
    private double lanceInicial;

    @Enumerated(EnumType.STRING)
    @Schema(hidden = true)
    private StatusDoProduto statusDoProduto;

    @ManyToOne
    @JoinColumn(name = "leilao_id", nullable = false)
    private Leilao leilao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConservacao() {
        return conservacao;
    }

    public void setConservacao(String conservacao) {
        this.conservacao = conservacao;
    }

    public String getEspecificacoesTecnicas() {
        return especificacoesTecnicas;
    }

    public void setEspecificacoesTecnicas(String especificacoesTecnicas) {
        this.especificacoesTecnicas = especificacoesTecnicas;
    }

    public double getLanceInicial() {
        return lanceInicial;
    }

    public void setLanceInicial(double lanceInicial) {
        this.lanceInicial = lanceInicial;
    }

    public StatusDoProduto getStatusDoProduto() {
        return statusDoProduto;
    }

    public void setStatusDoProduto(StatusDoProduto statusDoProduto) {
        this.statusDoProduto = statusDoProduto;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }
}

