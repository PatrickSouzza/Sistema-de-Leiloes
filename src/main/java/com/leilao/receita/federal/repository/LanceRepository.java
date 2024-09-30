package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.model.Lances;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceRepository extends JpaRepository<Lances, Long> {
    List<Lances> findByUsuarioId(Long usuarioId);


}
