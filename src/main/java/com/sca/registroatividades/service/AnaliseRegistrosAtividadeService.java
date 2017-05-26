package com.sca.registroatividades.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sca.registroatividades.model.Aluno;
import com.sca.registroatividades.model.Professor;
import com.sca.registroatividades.repository.AlunoRepository;
import com.sca.registroatividades.repository.ProfessorRepository;

@Component
public class AnaliseRegistrosAtividadeService {
	
	@Autowired
	private AlunoRepository alunoRepo;
	
	@Autowired
	private ProfessorRepository professorRepo;

	public List<Aluno> homeAnaliseAtividades(String matricula){
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Aluno> atividades = new ArrayList<Aluno>();
		
		Professor professor = getProfessorByMatricula(matricula);
		List<String> siglasCursos = new ArrayList<String>();
		
		siglasCursos = professor.getCursos();
		
		for(String curso : siglasCursos) {
			List<Aluno> aux = alunoRepo.findAlunosByCurso(curso);
			alunos.addAll(aux);
		}
		
		for(Aluno aluno : alunos) {
			if(aluno.getEstado().equals("EM_ANÁLISE")){
				atividades.add(aluno);
			}
			if(aluno.getEstado().equals("SUBMETIDO")){
				atividades.add(aluno);
			}
		}
		return atividades;
	}
	
	public void aprovarRegistroAtividade(String idAluno, String matriculaUsuario) {
		Professor professor = getProfessorByMatricula(matriculaUsuario);
		Aluno aluno = alunoRepo.findOne(Long.parseLong(idAluno));
		aluno.aprovarRegistroAtividadeAluno(professor.getId(), professor.getMatricula(), professor.getNome());
		alunoRepo.save(aluno);
	}
	
	public void recusarRegistroAtividade(String idAluno, String justificativa, String matriculaUsuario) {
		Professor professor = getProfessorByMatricula(matriculaUsuario);
		Aluno aluno = alunoRepo.findOne(Long.parseLong(idAluno));
		aluno.recusarRegistroAtividadeAluno(justificativa, professor.getId(), professor.getMatricula(), professor.getNome());
		alunoRepo.save(aluno);
	}
	
	private Professor getProfessorByMatricula(String matricula){
		return professorRepo.findProfessorByMatricula(matricula);
	}
}
