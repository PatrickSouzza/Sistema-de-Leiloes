package com.leilao.receita.federal.service;

import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.model.ProdutosPorLeilao;
import com.leilao.receita.federal.repository.InformaticaRepository;
import com.leilao.receita.federal.repository.LeilaoRepository;
import com.leilao.receita.federal.repository.VeiculoRepository;
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
}
