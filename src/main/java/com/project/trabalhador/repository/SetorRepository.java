package com.project.trabalhador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.trabalhador.model.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
	
	Optional<Setor> findByNome(String nome);

}
