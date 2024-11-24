package com.leilao.receita.federal.service;

import com.leilao.receita.federal.enums.EstadoDoLeilao;
import com.leilao.receita.federal.model.*;
import com.leilao.receita.federal.repository.InformaticaRepository;
import com.leilao.receita.federal.repository.LanceRepository;
import com.leilao.receita.federal.repository.LeilaoRepository;
import com.leilao.receita.federal.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private InformaticaRepository informaticaRepository;

    @Autowired
    private LanceRepository lanceRepository;

    public List<Leilao> getAllLeiloesOrdered(boolean ascending) {
        if (ascending) {
            return leilaoRepository.findAllByOrderByDataInicioAsc();
        } else {
            return leilaoRepository.findAllByOrderByDataInicioDesc();
        }
    }

    public List<Leilao> findAll() {
        return leilaoRepository.findAll();
    }

    public Optional<Leilao> findById(Long id) {
        return leilaoRepository.findById(id);
    }

    public Leilao save(Leilao leilao) {
        return leilaoRepository.save(leilao);
    }

    public void deleteById(Long id) {
        leilaoRepository.deleteById(id);
    }

    public ProdutosPorLeilao getProdutosPorLeilao(Long leilaoId) {
        ProdutosPorLeilao response = new ProdutosPorLeilao();
        response.setVeiculos(veiculoRepository.findByLeilaoIdOrderByNomeProdutoAsc(leilaoId));
        response.setInformatica(informaticaRepository.findByLeilaoIdOrderByNomeProdutoAsc(leilaoId));
        return response;
    }

    @Transactional
    public Leilao getDetalhesLeilao(Long leilaoId) {
        Leilao leilao = leilaoRepository.findById(leilaoId)
                .orElseThrow(() -> new IllegalArgumentException("Leilão não encontrado."));

        Date now = new Date();

        if (now.before(leilao.getDataInicio())) {
            leilao.setEstadoDoLeilao(EstadoDoLeilao.EmAberto);
        } else if (now.after(leilao.getDataInicio()) && now.before(leilao.getDataFim())) {
            leilao.setEstadoDoLeilao(EstadoDoLeilao.EmAndamento);
        } else if (now.after(leilao.getDataFim())) {
            leilao.setEstadoDoLeilao(EstadoDoLeilao.Finalizado);
        }

        leilaoRepository.save(leilao);

        if (leilao.getEstadoDoLeilao() == EstadoDoLeilao.Finalizado) {
            preencherGanhadores(leilao);
        }

        return leilao;
    }

    private void preencherGanhadores(Leilao leilao) {
        List<Veiculo> veiculos = veiculoRepository.findByLeilaoIdOrderByNomeProdutoAsc(leilao.getId());
        List<Informatica> informaticas = informaticaRepository.findByLeilaoIdOrderByNomeProdutoAsc(leilao.getId());

        for (Veiculo veiculo : veiculos) {
            Lance lanceVencedor = lanceRepository.findTopByVeiculoIdOrderByValorDesc(veiculo.getId());
            if (lanceVencedor != null) {
                veiculo.setLanceVencedor(lanceVencedor.getValor());
                veiculo.setGanhador(lanceVencedor.getUsuario());
            }
        }

        for (Informatica informatica : informaticas) {
            Lance lanceVencedor = lanceRepository.findTopByInformaticaIdOrderByValorDesc(informatica.getId());
            if (lanceVencedor != null) {
                informatica.setLanceVencedor(lanceVencedor.getValor());
                informatica.setGanhador(lanceVencedor.getUsuario());
            }
        }
    }
}
