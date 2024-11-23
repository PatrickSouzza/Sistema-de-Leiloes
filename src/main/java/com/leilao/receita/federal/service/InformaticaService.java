package com.leilao.receita.federal.service;

import com.leilao.receita.federal.enums.StatusDoProduto;
import com.leilao.receita.federal.model.Informatica;
import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.repository.InformaticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformaticaService {

    @Autowired
    private InformaticaRepository informaticaRepository;

    public List<Informatica> getAllInformatica() {
        return informaticaRepository.findAll();
    }

    public Optional<Informatica> getInformaticaById(Long id) {
        return informaticaRepository.findById(id);
    }

    public Informatica createInformatica(Informatica informatica) {
        informatica.setStatusDoProduto(StatusDoProduto.Disponivel);
        return informaticaRepository.save(informatica);
    }

    public Informatica updateInformatica(Long id, Informatica informatica) {
        if (!informaticaRepository.existsById(id)) {
            return null;
        }
        informatica.setId(id);
        return informaticaRepository.save(informatica);
    }

    public boolean deleteInformatica(Long id) {
        if (!informaticaRepository.existsById(id)) {
            return false;
        }
        informaticaRepository.deleteById(id);
        return true;
    }

    public Informatica updateLeilaoId(Long id, Leilao leilao) {
        Optional<Informatica> optionalInformatica = informaticaRepository.findById(id);

        if (optionalInformatica.isEmpty()) {
            return null;
        }

        Informatica informatica = optionalInformatica.get();
        informatica.setLeilao(leilao);
        return informaticaRepository.save(informatica);
    }
}

