package com.leilao.receita.federal.service;

import com.leilao.receita.federal.model.Informatica;
import com.leilao.receita.federal.model.Veiculo;
import com.leilao.receita.federal.repository.InformaticaRepository;
import com.leilao.receita.federal.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FiltroService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private InformaticaRepository informaticaRepository;

    public List<Veiculo> filtrarVeiculos(Double lanceMin, Double lanceMax, String nomeProduto) {
        return veiculoRepository.filtrarVeiculos(lanceMin, lanceMax, nomeProduto);
    }

    public List<Informatica> filtrarInformatica(Double lanceMin, Double lanceMax, String nomeProduto) {
        return informaticaRepository.filtarInformatica(lanceMin, lanceMax, nomeProduto);
    }
}
