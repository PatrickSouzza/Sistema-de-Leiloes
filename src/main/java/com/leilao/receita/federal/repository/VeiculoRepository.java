package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByLeilaoIdOrderByNomeProdutoAsc(Long leilaoId);
}
