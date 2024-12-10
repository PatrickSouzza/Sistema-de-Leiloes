package com.leilao.receita.federal.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.leilao.receita.federal.enums.StatusDoProduto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("VEICULO")
public class Veiculo extends Produto {

    @Schema(example = "Toyota")
    private String marca;

    @Schema(example = "Corola")
    private String modelo;

    @Schema(example = "Ótimo")
    private String conservacao;

    @Schema(example = "Automatico")
    private  String cambio;

    @Schema(example = "2022")
    private int anoFabricacao;

    @Schema(example = "50000")
    private int quilometragem;

    @Schema(example = "V8")
    private String motor;

    @Schema(example = "30000.00")
    private double lanceInicial;

    @Enumerated(EnumType.STRING)
    @Schema(hidden = true)
    private StatusDoProduto statusDoProduto;

    @ManyToOne
    @JoinColumn(name = "leilao_id", nullable = false)
    @JsonBackReference
    private Leilao leilao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario ganhador;

    private Double lanceVencedor;
//////////////////////////////////////////////////////////////

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

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
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

    public Usuario getGanhador() {
        return ganhador;
    }

    public void setGanhador(Usuario ganhador) {
        this.ganhador = ganhador;
    }

    public Double getLanceVencedor() {
        return lanceVencedor;
    }

    public void setLanceVencedor(Double lanceVencedor) {
        this.lanceVencedor = lanceVencedor;
    }
}
