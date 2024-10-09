package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.model.Lance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {
    List<Lance> findByUsuarioId(Long usuarioId);
    List<Lance> findByProdutoId(Long produtoId);
}
