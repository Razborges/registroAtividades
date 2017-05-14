package com.sca.registroatividades.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {

	@Id
	@GeneratedValue
	private Long id;
	
	private String matricula;
	
	@ElementCollection(fetch = FetchType.LAZY)
	private List<String> cursos;
	
	private String nome;
	
	public Professor(){};

	public Professor(String matricula, List<String> cursos, String nome) {
		super();
		this.matricula = matricula;
		this.cursos = cursos;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
