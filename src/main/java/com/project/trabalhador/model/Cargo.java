package com.project.trabalhador.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Cargo {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String nome;
	
	@OneToMany(mappedBy = "listaDeCargos", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties({"listaDeCargos"})
	private List<Trabalhador> trabalhadoresCargo = new ArrayList<>();
	
	@NotBlank
	@ManyToOne
	@JoinColumn(name = "id_setor")
	@JsonIgnoreProperties({"cargosRelacionados"})
	private Setor setorRelacionado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Trabalhador> getTrabalhadoresCargo() {
		return trabalhadoresCargo;
	}

	public void setTrabalhadoresCargo(List<Trabalhador> trabalhadoresCargo) {
		this.trabalhadoresCargo = trabalhadoresCargo;
	}

	public Setor getSetorRelacionado() {
		return setorRelacionado;
	}

	public void setSetorRelacionado(Setor setorRelacionado) {
		this.setorRelacionado = setorRelacionado;
	}


	
	
}
