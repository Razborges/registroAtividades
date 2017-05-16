package com.sca.registroatividades.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Aluno {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String matricula;
	private String curso;
	
	private String tipoAtividade;
	private String categoria;
	private Long cargaHoraria;
	private String estado;
	private String dataSolicitacao;

	private String contentType;
	private String nomeArquivo;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] data;
	
	private boolean aprovado = false;
	private boolean negado = false;
	
	private Long idAvaliador;
	private String matriculaAvaliador;
	private String nomeAvaliador;
	private String justificativa;
	private String dataAnalise;
	
	public Aluno(){}

	public Aluno(String nome, String matricula, String curso, String tipoAtividade, String categoria, Long cargaHoraria,
			String dataSolicitacao, String contentType, String nomeArquivo) {
		super();
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
		this.tipoAtividade = tipoAtividade;
		this.categoria = categoria;
		this.cargaHoraria = cargaHoraria;
		this.contentType = contentType;
		this.nomeArquivo = nomeArquivo;
		this.estado = "SUBMETIDO";
		this.dataSolicitacao = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}



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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Long getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Long cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(String dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public boolean isNegado() {
		return negado;
	}

	public void setNegado(boolean negado) {
		this.negado = negado;
	}

	public Long getIdAvaliador() {
		return idAvaliador;
	}

	public void setIdAvaliador(Long idAvaliador) {
		this.idAvaliador = idAvaliador;
	}

	public String getMatriculaAvaliador() {
		return matriculaAvaliador;
	}

	public void setMatriculaAvaliador(String matriculaAvaliador) {
		this.matriculaAvaliador = matriculaAvaliador;
	}

	public String getNomeAvaliador() {
		return nomeAvaliador;
	}

	public void setNomeAvaliador(String nomeAvaliador) {
		this.nomeAvaliador = nomeAvaliador;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getDataAnalise() {
		return dataAnalise;
	}

	public void setDataAnalise(String dataAnalise) {
		this.dataAnalise = dataAnalise;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", matricula=" + matricula + ", curso=" + curso + ", estado="
				+ estado + ", contentType=" + contentType + "]";
	}
	
}
