package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.enums.TipoProduto;
import com.leilao.receita.federal.model.Informatica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformaticaRepository extends JpaRepository<Informatica, Long> {

    List<Informatica> findAll();

    List<Informatica> findByLeilaoIdOrderByNomeProdutoAsc(Long leilaoId);

    List<Informatica> findByLanceInicialBetween(Double lanceMin, Double lanceMax);

    @Query("SELECT i FROM Informatica i WHERE i.lanceInicial + (SELECT SUM(l.valor) FROM Lance l WHERE l.informatica.id = i.id) BETWEEN :lanceMin AND :lanceMax")
    List<Informatica> findByLanceTotalBetween(@Param("lanceMin") Double lanceMin, @Param("lanceMax") Double lanceMax);

    List<Informatica> findByNomeProdutoContaining(String nomeProduto);

}
