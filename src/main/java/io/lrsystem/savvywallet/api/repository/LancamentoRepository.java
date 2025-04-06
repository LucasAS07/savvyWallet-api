package io.lrsystem.savvywallet.api.repository;

import io.lrsystem.savvywallet.api.model.Lancamento;
import io.lrsystem.savvywallet.api.repository.lancamento.LancamentoRepositoryQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {
    
}
