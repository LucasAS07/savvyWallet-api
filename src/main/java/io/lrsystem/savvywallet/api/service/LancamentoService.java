package io.lrsystem.savvywallet.api.service;

import java.util.Optional;

import io.lrsystem.savvywallet.api.model.Lancamento;
import io.lrsystem.savvywallet.api.model.Pessoa;
import io.lrsystem.savvywallet.api.repository.LancamentoRepository;
import io.lrsystem.savvywallet.api.repository.PessoaRepository;
import io.lrsystem.savvywallet.api.service.exception.PessoaInexistenteOuInativaException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LancamentoService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired 
	private LancamentoRepository lancamentoRepository;

	public Lancamento salvar(Lancamento lancamento) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
		if (pessoa.isEmpty() || pessoa.get().isInativo()) {
			throw new PessoaInexistenteOuInativaException();
		}
		
		return lancamentoRepository.save(lancamento);
	}
	
}
