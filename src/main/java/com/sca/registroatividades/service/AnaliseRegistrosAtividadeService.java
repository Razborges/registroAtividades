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
		//System.out.println(matricula); // OK
		//System.out.println(professor.getNome()); // OK
		
		List<String> siglasCursos = new ArrayList<String>();
		
		siglasCursos = professor.getCursos();
		//System.out.println(siglasCursos); // OK
		
		for(String curso : siglasCursos) {
			//System.out.println(curso); // OK
			List<Aluno> aux = alunoRepo.findAlunosByCurso(curso);
			alunos.addAll(aux);
		}
		
		//System.out.println(alunos); // OK
		for(Aluno aluno : alunos) {
			//System.out.println(aluno); // OK
			//System.out.println(aluno.getEstado()); // OK
			if(aluno.getEstado().equals("EM_AVALIACAO")){
				//System.out.println(aluno); // OK
				atividades.add(aluno);
			}
			if(aluno.getEstado().equals("SUBMETIDO")){
				//System.out.println(aluno); // OK
				atividades.add(aluno);
			}
		}
		
		//System.out.println(atividades); //OK
		
		return atividades;
	}
	
	private Professor getProfessorByMatricula(String matricula){
		return professorRepo.findProfessorByMatricula(matricula);
	}
}
