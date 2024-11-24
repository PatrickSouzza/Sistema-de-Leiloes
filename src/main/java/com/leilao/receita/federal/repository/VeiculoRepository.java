package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.enums.TipoProduto;
import com.leilao.receita.federal.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByLeilaoIdOrderByNomeProdutoAsc(Long leilaoId);

    List<Veiculo> findByLanceInicialBetween(Double lanceMin, Double lanceMax);

    @Query("SELECT v FROM Veiculo v WHERE v.lanceInicial + (SELECT SUM(l.valor) FROM Lance l WHERE l.veiculo.id = v.id) BETWEEN :lanceMin AND :lanceMax")
    List<Veiculo> findByLanceTotalBetween(@Param("lanceMin") Double lanceMin, @Param("lanceMax") Double lanceMax);

    List<Veiculo> findByNomeProdutoContaining(String nomeProduto);

}