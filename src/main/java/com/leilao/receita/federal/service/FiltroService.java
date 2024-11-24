package com.leilao.receita.federal.service;

import com.leilao.receita.federal.enums.TipoProduto;
import com.leilao.receita.federal.model.Informatica;
import com.leilao.receita.federal.model.ProdutosPorLeilao;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.repository.InformaticaRepository;
import com.leilao.receita.federal.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiltroService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private InformaticaRepository informaticaRepository;

    public List<Veiculo> filtrarVeiculos(Double lanceMin, Double lanceMax, String nomeProduto) {
        List<Veiculo> veiculos = new ArrayList<>();

        if (lanceMin != null && lanceMax != null) {
            veiculos.addAll(veiculoRepository.findByLanceInicialBetween(lanceMin, lanceMax));
        }

        if (lanceMin != null && lanceMax != null) {
            veiculos.addAll(veiculoRepository.findByLanceTotalBetween(lanceMin, lanceMax));
        }

        if (nomeProduto != null && !nomeProduto.isEmpty()) {
            veiculos.addAll(veiculoRepository.findByNomeProdutoContaining(nomeProduto));
        }

        return veiculos;
    }

    public List<Informatica> filtrarInformaticas(Double lanceMin, Double lanceMax, String nomeProduto) {
        List<Informatica> informaticas = new ArrayList<>();

        if (lanceMin != null && lanceMax != null) {
            informaticas.addAll(informaticaRepository.findByLanceInicialBetween(lanceMin, lanceMax));
        }

        if (lanceMin != null && lanceMax != null) {
            informaticas.addAll(informaticaRepository.findByLanceTotalBetween(lanceMin, lanceMax));
        }

        if (nomeProduto != null && !nomeProduto.isEmpty()) {
            informaticas.addAll(informaticaRepository.findByNomeProdutoContaining(nomeProduto));
        }

        return informaticas;
    }
}
