package com.leilao.receita.federal.service;

import com.leilao.receita.federal.model.Informatica;
import com.leilao.receita.federal.model.Lance;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.repository.InformaticaRepository;
import com.leilao.receita.federal.repository.LanceRepository;
import com.leilao.receita.federal.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LanceService {

    @Autowired
    private LanceRepository lanceRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private InformaticaRepository informaticaRepository;

    public Lance getLanceById(Long id) {
        return lanceRepository.findById(id).orElse(null);
    }

    public List<Lance> getLancesByUsuarioId(Long usuarioId) {
        return lanceRepository.findByUsuarioId(usuarioId);
    }

    public List<Lance> getLancesByVeiculoId(Long veiculoId) {
        return lanceRepository.findByVeiculoId(veiculoId);
    }

    public List<Lance> getLancesByInformaticaId(Long informaticaId) {
        return lanceRepository.findByInformaticaId(informaticaId);
    }

    public Lance saveLance(Lance lance) {
        if (lance.getVeiculo() != null) {
            validarLanceParaVeiculo(lance);
        } else if (lance.getInformatica() != null) {
            validarLanceParaInformatica(lance);
        } else {
            throw new IllegalArgumentException("Lance deve estar associado a um veículo ou produto de informática.");
        }

        return lanceRepository.save(lance);
    }

    private void validarLanceParaVeiculo(Lance lance) {
        Veiculo veiculo = veiculoRepository.findById(lance.getVeiculo().getId())
                .orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado."));

        if (lance.getValor() <= veiculo.getLanceInicial()) {
            throw new IllegalArgumentException("O lance deve ser maior que o lance inicial.");
        }

        Double ultimoLance = lanceRepository.findMaxValorByVeiculoId(veiculo.getId());
        if (ultimoLance != null && lance.getValor() <= ultimoLance) {
            throw new IllegalArgumentException("O lance deve ser maior que o último lance registrado.");
        }

        if (veiculo.getLeilao().getDataFim().before(new Date())) {
            throw new IllegalArgumentException("O lance não pode ser registrado após o fim do leilão.");
        }
    }

    private void validarLanceParaInformatica(Lance lance) {
        Informatica informatica = informaticaRepository.findById(lance.getInformatica().getId())
                .orElseThrow(() -> new IllegalArgumentException("Produto de informática não encontrado."));

        if (lance.getValor() <= informatica.getLanceInicial()) {
            throw new IllegalArgumentException("O lance deve ser maior que o lance inicial.");
        }

        Double ultimoLance = lanceRepository.findMaxValorByInformaticaId(informatica.getId());
        if (ultimoLance != null && lance.getValor() <= ultimoLance) {
            throw new IllegalArgumentException("O lance deve ser maior que o último lance registrado.");
        }

        if (informatica.getLeilao().getDataFim().before(new Date())) {
            throw new IllegalArgumentException("O lance não pode ser registrado após o fim do leilão.");
        }
    }
}
