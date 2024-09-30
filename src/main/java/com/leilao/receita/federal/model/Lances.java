package com.leilao.receita.federal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Lances {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @Schema(description = "Nome do Usuário", example = "Patrick Gabriel de Souza")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    @Schema(example = "1")
    private Produto produto;
    @Schema(example = "99.0")
    private Double valorDoLance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValorDoLance() {
        return valorDoLance;
    }

    public void setValorDoLance(Double valorDoLance) {
        this.valorDoLance = valorDoLance;
    }
}

