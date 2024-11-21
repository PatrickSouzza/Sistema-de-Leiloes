package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.model.Leilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LeilaoRepository extends JpaRepository<Leilao, Long> {
    List<Leilao> findAllByOrderByDataInicioAsc();

    List<Leilao> findAllByOrderByDataInicioDesc();
}
