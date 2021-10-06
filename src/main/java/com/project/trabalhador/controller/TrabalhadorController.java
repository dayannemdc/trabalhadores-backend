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

import com.project.trabalhador.model.Trabalhador;
import com.project.trabalhador.repository.TrabalhadorRepository;
import com.project.trabalhador.service.TrabalhadorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/trabalhador")
public class TrabalhadorController {

private @Autowired TrabalhadorRepository repository;
private @Autowired TrabalhadorService service;
	
	@GetMapping("/todos")
	public List<Trabalhador> pegarTodos() {
		return repository.findAll();
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Trabalhador novoTrabalhador) {
		Optional<Object> objetoCadastrado = service.cadastrarTrabalhador(novoTrabalhador);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@GetMapping("/{id_trabalhador}")
	public ResponseEntity<Trabalhador> buscarPorId(@PathVariable(value = "id_trabalhador") Long idTrabalhador) {
		Optional<Trabalhador> objetoTrabalhador = repository.findById(idTrabalhador);
		if (objetoTrabalhador.isPresent()) {
			return ResponseEntity.status(200).body(objetoTrabalhador.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}
	@PutMapping("/atualizar")
	public ResponseEntity<Object> atualizar(@Valid @RequestBody Trabalhador trabalhadorParaAtualizar) {
		Optional<Object> objetoParaAtualizar = service.atualizarTrabalhador(trabalhadorParaAtualizar);

		if (objetoParaAtualizar.isPresent()) {
			return ResponseEntity.status(201).body(objetoParaAtualizar.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@DeleteMapping("/deletar/{id_trabalhador}")
	public void deletarPorId(@PathVariable(value = "id_trabalhador") Long idTrbalhador) {
		repository.deleteById(idTrbalhador);
	}
}
