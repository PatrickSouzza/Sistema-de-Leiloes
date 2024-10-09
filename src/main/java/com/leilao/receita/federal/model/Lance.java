package com.leilao.receita.federal.model;

import com.leilao.receita.federal.enums.TipoProduto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Lance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "produto_id", nullable = false)
    private Long produtoId;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Schema(description = "Valor do lance", example = "99.0")
    private BigDecimal valorDoLance;

    @Temporal(TemporalType.TIMESTAMP)
    @Schema(description = "Data e hora do lance", example = "2024-10-10T18:00:00Z")
    private Date dataLance;

    @Transient
    private String nomeProduto;

    @Transient
    private TipoProduto tipoProduto;

    @Transient
    private String descricaoProduto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorDoLance() {
        return valorDoLance;
    }

    public void setValorDoLance(BigDecimal valorDoLance) {
        this.valorDoLance = valorDoLance;
    }

    public Date getDataLance() {
        return dataLance;
    }

    public void setDataLance(Date dataLance) {
        this.dataLance = dataLance;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
