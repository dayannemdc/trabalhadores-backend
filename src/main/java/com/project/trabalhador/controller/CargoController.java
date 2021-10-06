package com.project.trabalhador.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.trabalhador.model.Cargo;
import com.project.trabalhador.repository.CargoRepository;
import com.project.trabalhador.service.CargoService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/cargo")
public class CargoController {

private @Autowired CargoRepository repository;
private @Autowired CargoService service;
	
	@GetMapping("/todos")
	public List<Cargo> pegarTodos() {
		return repository.findAll();
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Cargo novoCargo) {
		Optional<Object> objetoCadastrado = service.cadastrarCargo(novoCargo);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@GetMapping("/{id_setor}")
	public ResponseEntity<Cargo> buscarPorId(@PathVariable(value = "id_setor") Long idCargo) {
		Optional<Cargo> objetoCargo = repository.findById(idCargo);
		if (objetoCargo.isPresent()) {
			return ResponseEntity.status(200).body(objetoCargo.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Cargo> atualizar(@Valid @RequestBody Cargo cargoParaAtualizar) {
		Optional<Cargo> objetoParaAtualizar = service.alterarCargo(cargoParaAtualizar);

		if (objetoParaAtualizar.isPresent()) {
			return ResponseEntity.status(201).body(objetoParaAtualizar.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@DeleteMapping("/deletar/{id_cargo}")
	public void deletarPorId(@PathVariable(value = "id_cargo") Long idCargo) {
		repository.deleteById(idCargo);
	}
}
