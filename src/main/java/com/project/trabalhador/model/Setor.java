package com.project.trabalhador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Setor {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idSetor;
	private String nome;
	
	@OneToMany(mappedBy = "setorRelacionado", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"setorRelacionado"})
	private List<Cargo> cargosRelacionados = new ArrayList<>();

	public Long getId() {
		return idSetor;
	}

	public void setId(Long idSetor) {
		this.idSetor = idSetor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargosRelacionados() {
		return cargosRelacionados;
	}

	public void setCargosRelacionados(List<Cargo> cargosRelacionados) {
		this.cargosRelacionados = cargosRelacionados;
	}

	
	
}
