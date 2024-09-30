package com.leilao.receita.federal.service;

import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.repository.LeilaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeilaoService {

    @Autowired
    private LeilaoRepository leilaoRepository;

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
}
