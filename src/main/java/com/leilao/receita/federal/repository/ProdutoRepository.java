package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
