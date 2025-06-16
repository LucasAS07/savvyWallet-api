package io.lrsystem.savvywallet.api.service;

import io.lrsystem.savvywallet.api.model.Pessoa;
import io.lrsystem.savvywallet.api.repository.PessoaRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
 	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);

		// Limpa os contatos existentes
		pessoaSalva.getContatos().clear();

		// Adiciona novos contatos, se não forem nulos
		if (pessoa.getContatos() != null) {
			pessoaSalva.getContatos().addAll(pessoa.getContatos());
			pessoaSalva.getContatos().forEach(c -> c.setPessoa(pessoaSalva));
		}

		// Copia as demais propriedades, exceto codigo e contatos
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo", "contatos");

		return pessoaRepository.save(pessoaSalva);
	}

	
	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Pessoa pessoaSalva = buscarPessoaPeloCodigo(codigo);
		pessoaSalva.setAtivo(ativo);
		pessoaRepository.save(pessoaSalva);
	}

	public Pessoa buscarPessoaPeloCodigo(Long codigo) {
		Pessoa pessoaSalva =  pessoaRepository.findById(codigo)
								.orElseThrow(() -> new EmptyResultDataAccessException(1));

		return pessoaSalva;
	}

	public Pessoa salvar(Pessoa pessoa){
		pessoa.getContatos().forEach(c -> c.setPessoa(pessoa));
		return pessoaRepository.save(pessoa);
	}

}
