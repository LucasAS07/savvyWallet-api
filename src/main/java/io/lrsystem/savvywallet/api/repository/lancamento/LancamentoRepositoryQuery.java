package io.lrsystem.savvywallet.api.repository.lancamento;

import io.lrsystem.savvywallet.api.dto.LancamentoEstatisticaCategoria;
import io.lrsystem.savvywallet.api.dto.LancamentoEstatisticaDia;
import io.lrsystem.savvywallet.api.dto.LancamentoEstatisticaPessoa;
import io.lrsystem.savvywallet.api.model.Lancamento;
import io.lrsystem.savvywallet.api.repository.filter.LancamentoFilter;

import io.lrsystem.savvywallet.api.repository.projection.ResumoLancamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;


public interface LancamentoRepositoryQuery {

	public List<LancamentoEstatisticaPessoa> porPessoa(LocalDate inicio, LocalDate fim);
	public List<LancamentoEstatisticaCategoria> porCategoria(LocalDate mesReferencia);
	public List<LancamentoEstatisticaDia> porDia(LocalDate mesReferencia);

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	public Page<ResumoLancamento> resumir(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}
