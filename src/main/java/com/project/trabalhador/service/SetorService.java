package com.project.trabalhador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.trabalhador.model.Setor;
import com.project.trabalhador.repository.SetorRepository;

@Service
public class SetorService {

	private @Autowired SetorRepository repository;
	
	public Optional<Object> cadastrarSetor(Setor novoSetor) {
		return repository.findByNome(novoSetor.getNome()).map(setorExistente ->{
			return Optional.empty();
		}).orElseGet(()->{
			return Optional.ofNullable(repository.save(novoSetor));
		});
	}
	
	public Optional<Setor> alterarSetor(Setor setorParaAlterar) {
		return repository.findById(setorParaAlterar.getId()).map(setorExistente -> {
			setorExistente.setNome(setorParaAlterar.getNome());
			return Optional.ofNullable(repository.save(setorExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
}
