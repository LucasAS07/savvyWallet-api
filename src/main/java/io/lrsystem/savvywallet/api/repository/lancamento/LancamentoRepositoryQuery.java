package io.lrsystem.savvywallet.api.repository.lancamento;

import io.lrsystem.savvywallet.api.model.Lancamento;
import io.lrsystem.savvywallet.api.repository.filter.LancamentoFilter;

import io.lrsystem.savvywallet.api.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}
