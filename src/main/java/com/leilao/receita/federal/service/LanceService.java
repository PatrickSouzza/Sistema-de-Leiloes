package com.leilao.receita.federal.service;

import com.leilao.receita.federal.model.Lance;
import com.leilao.receita.federal.repository.LanceRepository; // Repositório para a entidade Lances
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanceService {

    @Autowired
    private LanceRepository lanceRepository;

    public Lance getLanceById(Long id) {
        return lanceRepository.findById(id).orElse(null);
    }

    public List<Lance> getLancesByUsuarioId(Long usuarioId) {
        return lanceRepository.findByUsuarioId(usuarioId);
    }

    public List<Lance> getLancesByProdutoId(Long produtoId) {
        return lanceRepository.findByProdutoId(produtoId);
    }

    public Lance saveLance(Lance lance) {
        return lanceRepository.save(lance);
    }
}
