package com.sca.registroatividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sca.registroatividades.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
	
	Professor findProfessorByMatricula(String matricula);

}
