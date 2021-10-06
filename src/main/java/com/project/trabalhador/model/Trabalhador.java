package com.project.trabalhador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Trabalhador {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long idTrabalhador;
	private @NotBlank String nome;
	private @NotNull Long cpf;
	private String sexo;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_cargo")
	@JsonIgnoreProperties({"trabalhadoresCargo"})
	private Cargo listaDeCargos;

	public Long getId() {
		return idTrabalhador;
	}

	public void setId(Long idTrabalhador) {
		this.idTrabalhador = idTrabalhador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Cargo getListaDeCargos() {
		return listaDeCargos;
	}

	public void setListaDeCargos(Cargo listaDeCargos) {
		this.listaDeCargos = listaDeCargos;
	}

	
}
