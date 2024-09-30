package com.leilao.receita.federal.service;

import com.leilao.receita.federal.model.Lances;
import com.leilao.receita.federal.repository.LanceRepository; // Repositório para a entidade Lances
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanceService {

    @Autowired
    private LanceRepository lanceRepository;

    public List<Lances> findLancesByUsuarioId(Long usuarioId) {
        return lanceRepository.findByUsuarioId(usuarioId);
    }

    public Lances saveLance(Lances lance) {
        return lanceRepository.save(lance);
    }
}
