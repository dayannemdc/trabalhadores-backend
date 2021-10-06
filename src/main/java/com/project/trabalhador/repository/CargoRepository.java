package com.project.trabalhador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.trabalhador.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

	Optional<Cargo> findByNome(String nome);
}
