package io.lrsystem.savvywallet.api.repository;

import io.lrsystem.savvywallet.api.model.Pessoa;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;



@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    public Page<Pessoa> findByNomeContaining(String nome, Pageable pageable);
}
