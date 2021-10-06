package com.project.trabalhador.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.trabalhador.model.Cargo;
import com.project.trabalhador.repository.CargoRepository;

@Service
public class CargoService {

	private @Autowired CargoRepository repository;
	
	public Optional<Object> cadastrarCargo(Cargo novoSetor) {
		return repository.findByNome(novoSetor.getNome()).map(setorExistente ->{
			return Optional.empty();
		}).orElseGet(()->{
			return Optional.ofNullable(repository.save(novoSetor));
		});
	}
	
	public Optional<Cargo> alterarCargo(Cargo cargoParaAlterar) {
		return repository.findById(cargoParaAlterar.getId()).map(cargoExistente -> {
			cargoExistente.setNome(cargoParaAlterar.getNome());
			return Optional.ofNullable(repository.save(cargoExistente));
		}).orElseGet(() -> {
			return Optional.empty();
		});
	}
	
}
