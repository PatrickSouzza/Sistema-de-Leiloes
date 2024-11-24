package com.leilao.receita.federal.service;

import com.leilao.receita.federal.enums.StatusDoProduto;
import com.leilao.receita.federal.model.Leilao;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> getVeiculoById(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo createVeiculo(Veiculo veiculo) {
        veiculo.setStatusDoProduto(StatusDoProduto.Disponivel);
        return veiculoRepository.save(veiculo);
    }

    public Veiculo updateVeiculo(Long id, Veiculo veiculo) {
        if (!veiculoRepository.existsById(id)) {
            return null;
        }
        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }

    public boolean deleteVeiculo(Long id) {
        if (!veiculoRepository.existsById(id)) {
            return false;
        }
        veiculoRepository.deleteById(id);
        return true;
    }

    public Veiculo updateLeilaoId(Long veiculoId, Leilao leilao) {
        Optional<Veiculo> optionalVeiculo = veiculoRepository.findById(veiculoId);

        if (optionalVeiculo.isEmpty()) {
            return null;
        }

        Veiculo veiculo = optionalVeiculo.get();
        veiculo.setLeilao(leilao);
        return veiculoRepository.save(veiculo);
    }
}

