package com.leilao.receita.federal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leilao.receita.federal.enums.StatusDoProduto;
import com.leilao.receita.federal.model.Informatica;
import com.leilao.receita.federal.model.Lance;
import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExportacaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private InformaticaRepository informaticaRepository;

    @Autowired
    private LanceRepository lanceRepository;

    @Autowired
    private EntidadeFinanceiraRepository entidadeFinanceiraRepository;

    public void exportarDetalhesLeilao(Long leilaoId) throws IOException {
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new IllegalArgumentException("Leilão não encontrado."));

        Map<String, Object> leilaoData = new HashMap<>();
        leilaoData.put("leilaoId", leilao.getId());
        leilaoData.put("nome", leilao.getNome());
        leilaoData.put("dataInicio", leilao.getDataInicio());
        leilaoData.put("dataFim", leilao.getDataFim());
        leilaoData.put("estadoDoLeilao", leilao.getEstadoDoLeilao());

        List<Map<String, Object>> entidadesFinanceiras = entidadeFinanceiraRepository.findByLeilaoId(leilaoId)
                .stream()
                .map(entidade -> {
                    Map<String, Object> entidadeData = new HashMap<>();
                    entidadeData.put("id", entidade.getId());
                    entidadeData.put("nome", entidade.getNomeEntidade());
                    return entidadeData;
                })
                .collect(Collectors.toList());
        leilaoData.put("entidadesFinanceiras", entidadesFinanceiras);

        List<Map<String, Object>> produtosData = new ArrayList<>();

        List<Veiculo> veiculos = veiculoRepository.findByLeilaoIdOrderByNomeProdutoAsc(leilaoId);
        for (Veiculo veiculo : veiculos) {
            Map<String, Object> veiculoData = new HashMap<>();
            veiculoData.put("id", veiculo.getId());
            veiculoData.put("nomeProduto", veiculo.getNomeProduto());
            veiculoData.put("anoDeFabricacao", veiculo.getAnoFabricacao());
            veiculoData.put("lanceInicial", veiculo.getLanceInicial());
            veiculoData.put("status", veiculo.getStatusDoProduto());

            if (veiculo.getStatusDoProduto() == StatusDoProduto.Vendido) {
                Lance ultimoLance = lanceRepository.findTopByVeiculoIdOrderByValorDesc(veiculo.getId());
                if (ultimoLance != null) {
                    Map<String, Object> ganhador = new HashMap<>();
                    ganhador.put("id", ultimoLance.getUsuario().getId());
                    ganhador.put("nome", ultimoLance.getUsuario().getNome());
                    veiculoData.put("ganhador", ganhador);
                }
            }

            List<Map<String, Object>> historicoLances = lanceRepository.findByVeiculoId(veiculo.getId())
                    .stream()
                    .map(lance -> {
                        Map<String, Object> lanceData = new HashMap<>();
                        lanceData.put("usuarioId", lance.getUsuario().getId());
                        lanceData.put("valorLance", lance.getValor());
                        lanceData.put("dataLance", lance.getDataHora());
                        return lanceData;
                    })
                    .collect(Collectors.toList());
            veiculoData.put("historicoLances", historicoLances);

            produtosData.add(veiculoData);
        }

        List<Informatica> informaticas = informaticaRepository.findByLeilaoIdOrderByNomeProdutoAsc(leilaoId);
        for (Informatica informatica : informaticas) {
            Map<String, Object> informaticaData = new HashMap<>();
            informaticaData.put("id", informatica.getId());
            informaticaData.put("nomeProduto", informatica.getNomeProduto());
            informaticaData.put("descricao", informatica.getEspecificacoesTecnicas());
            informaticaData.put("lanceInicial", informatica.getLanceInicial());
            informaticaData.put("status", informatica.getStatusDoProduto());

            if (informatica.getStatusDoProduto() == StatusDoProduto.Vendido) {
                Lance ultimoLance = lanceRepository.findTopByInformaticaIdOrderByValorDesc(informatica.getId());
                if (ultimoLance != null) {
                    Map<String, Object> ganhador = new HashMap<>();
                    ganhador.put("id", ultimoLance.getUsuario().getId());
                    ganhador.put("nome", ultimoLance.getUsuario().getNome());
                    informaticaData.put("ganhador", ganhador);
                }
            }

            List<Map<String, Object>> historicoLances = lanceRepository.findByInformaticaId(informatica.getId())
                    .stream()
                    .map(lance -> {
                        Map<String, Object> lanceData = new HashMap<>();
                        lanceData.put("usuarioId", lance.getUsuario().getId());
                        lanceData.put("valorLance", lance.getValor());
                        lanceData.put("dataLance", lance.getDataHora());
                        return lanceData;
                    })
                    .collect(Collectors.toList());
            informaticaData.put("historicoLances", historicoLances);

            produtosData.add(informaticaData);
        }

        leilaoData.put("produtos", produtosData);

        gerarArquivoDet(leilaoData);
    }

    private void gerarArquivoDet(Map<String, Object> leilaoData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(leilaoData);

        File arquivo = new File("leilao_" + leilaoData.get("leilaoId") + ".DET");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write(json);
        }
        System.out.println("Arquivo .DET gerado com sucesso em: " + arquivo.getAbsolutePath());
    }
}
