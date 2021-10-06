package com.project.trabalhador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.trabalhador.model.Trabalhador;
import com.project.trabalhador.repository.TrabalhadorRepository;

@Service
public class TrabalhadorService {

	private @Autowired TrabalhadorRepository repository;
	
	public Optional<Object> cadastrarTrabalhador(Trabalhador novoTrabalhador) {
		return repository.findByCpf(novoTrabalhador.getCpf()).map(trabalhadorExistente ->{
			return Optional.empty();
		}).orElseGet(()->{
			return Optional.ofNullable(repository.save(novoTrabalhador));
		});
	}
	
	public Optional<Object> atualizarTrabalhador(Trabalhador trabalhadorParaAtualizar) {
		return repository.findByCpf(trabalhadorParaAtualizar.getCpf()).map(trabalhadorExistente ->{
			return Optional.empty();
		}).orElseGet(()->{
			return Optional.ofNullable(repository.save(trabalhadorParaAtualizar));
		});
	}
}
