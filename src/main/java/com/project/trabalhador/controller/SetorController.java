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

import com.project.trabalhador.model.Setor;
import com.project.trabalhador.repository.SetorRepository;
import com.project.trabalhador.service.SetorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/setor")
public class SetorController {

	private @Autowired SetorRepository repository;
	private @Autowired SetorService service;

	@GetMapping("/todos")
	public List<Setor> pegarTodos() {
		return repository.findAll();
	}

	@PostMapping("/salvar")
	public ResponseEntity<Object> salvar(@Valid @RequestBody Setor novoSetor) {
		Optional<Object> objetoCadastrado = service.cadastrarSetor(novoSetor);

		if (objetoCadastrado.isPresent()) {
			return ResponseEntity.status(201).body(objetoCadastrado.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@GetMapping("/{id_setor}")
	public ResponseEntity<Setor> buscarPorId(@PathVariable(value = "id_setor") Long idSetor) {
		Optional<Setor> objetoSetor = repository.findById(idSetor);
		if (objetoSetor.isPresent()) {
			return ResponseEntity.status(200).body(objetoSetor.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Setor> atualizar(@Valid @RequestBody Setor setorParaAtualizar) {
		Optional<Setor> objetoParaAtualizar = service.alterarSetor(setorParaAtualizar);

		if (objetoParaAtualizar.isPresent()) {
			return ResponseEntity.status(201).body(objetoParaAtualizar.get());
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@DeleteMapping("/deletar/{id_setor}")
	public void deletarPorId(@PathVariable(value = "id_setor") Long idSetor) {
		repository.deleteById(idSetor);
	}
}
