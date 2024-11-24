package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.model.Informatica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InformaticaRepository extends JpaRepository<Informatica, Long> {
    List<Informatica> findByLeilaoIdOrderByNomeProdutoAsc(Long leilaoId);
}
