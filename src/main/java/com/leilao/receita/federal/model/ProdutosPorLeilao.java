package com.leilao.receita.federal.model;

import java.util.List;

public class ProdutosPorLeilao {

    private List<Veiculo> veiculos;
    private List<Informatica> informatica;
    private int totalVeiculos;
    private int totalInformatica;
    private int totalProdutos;

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
        this.totalVeiculos = veiculos != null ? veiculos.size() : 0;
        atualizarTotalProdutos();
    }

    public List<Informatica> getInformatica() {
        return informatica;
    }

    public void setInformatica(List<Informatica> informatica) {
        this.informatica = informatica;
        this.totalInformatica = informatica != null ? informatica.size() : 0;
        atualizarTotalProdutos();
    }

    public int getTotalVeiculos() {
        return totalVeiculos;
    }

    public int getTotalInformatica() {
        return totalInformatica;
    }

    public int getTotalProdutos() {
        return totalProdutos;
    }

    private void atualizarTotalProdutos() {
        this.totalProdutos = this.totalVeiculos + this.totalInformatica;
    }
}
