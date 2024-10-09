package com.leilao.receita.federal.service;

import com.leilao.receita.federal.model.EntidadeFinanceira;
import com.leilao.receita.federal.model.Produto;
import com.leilao.receita.federal.repository.EntidadeFinanceiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntidadeService {

    @Autowired
    private EntidadeFinanceiraRepository entidadeRepository;

    public List<EntidadeFinanceira> getAllEntidades() {
        return entidadeRepository.findAll();
    }


    public Optional<EntidadeFinanceira> getEntidadeById(Long id) {
        return entidadeRepository.findById(id);
    }

    public EntidadeFinanceira createEntidade(EntidadeFinanceira entidadeFinanceira) {
        return entidadeRepository.save(entidadeFinanceira);
    }

    public EntidadeFinanceira updateEntidade(Long id, EntidadeFinanceira entidadeFinanceira) {
        if (!entidadeRepository.existsById(id)) {
            return null;
        }
        entidadeFinanceira.setId(id);
        return entidadeRepository.save(entidadeFinanceira);
    }

    public boolean deleteEntidade(Long id) {
        if (!entidadeRepository.existsById(id)) {
            return false;
        }
        entidadeRepository.deleteById(id);
        return true;
    }
}
