package com.leilao.receita.federal.repository;

import com.leilao.receita.federal.model.EntidadeFinanceira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntidadeFinanceiraRepository extends JpaRepository<EntidadeFinanceira, Long> {

}
