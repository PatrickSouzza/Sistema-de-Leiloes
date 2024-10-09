package com.leilao.receita.federal.model;

import com.leilao.receita.federal.enums.StatusDoProduto;
import com.leilao.receita.federal.enums.TipoProduto;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(hidden = true)
    private Long id;
    @Schema(example = "Notebook ACER")
    private String nomeProduto;
    @Schema(example = "Informatica")
    private TipoProduto tipoProduto;
    @Schema(example = "Notebook I5 com uma rtx2060")
    private String descricao;
    @Column(name = "leilao_id", nullable = false)
    private Long leilaoId;
    @Schema(example = "50.00")
    private double lanceInicial;
    @Schema(hidden = true)
    private StatusDoProduto statusDoProduto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLanceInicial() {
        return lanceInicial;
    }

    public void setLanceInicial(double lanceInicial) {
        this.lanceInicial = lanceInicial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getLeilaoId() {
        return leilaoId;
    }

    public void setLeilaoId(Long leilaoId) {
        this.leilaoId = leilaoId;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public StatusDoProduto getStatusDoProduto() {
        return statusDoProduto;
    }

    public void setStatusDoProduto(StatusDoProduto statusDoProduto) {
        this.statusDoProduto = statusDoProduto;
    }

}
