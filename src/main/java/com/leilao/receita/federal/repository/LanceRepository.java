package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.model.Lance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Long> {
    List<Lance> findByUsuarioId(Long usuarioId);

    List<Lance> findByVeiculoId(Long veiculoId);

    List<Lance> findByInformaticaId(Long informaticaId);

    @Query("SELECT MAX(l.valor) FROM Lance l WHERE l.veiculo.id = :veiculoId")
    Double findMaxValorByVeiculoId(@Param("veiculoId") Long veiculoId);

    @Query("SELECT MAX(l.valor) FROM Lance l WHERE l.informatica.id = :informaticaId")
    Double findMaxValorByInformaticaId(@Param("informaticaId") Long informaticaId);

    @Query("SELECT l FROM Lance l WHERE l.veiculo.id = :veiculoId ORDER BY l.valor DESC")
    Lance findTopByVeiculoIdOrderByValorDesc(@Param("veiculoId") Long veiculoId);

    @Query("SELECT l FROM Lance l WHERE l.informatica.id = :informaticaId ORDER BY l.valor DESC")
    Lance findTopByInformaticaIdOrderByValorDesc(@Param("informaticaId") Long informaticaId);
}

