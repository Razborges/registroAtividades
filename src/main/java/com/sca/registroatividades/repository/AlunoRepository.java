package com.sca.registroatividades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sca.registroatividades.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query("SELECT a from Aluno a WHERE a.curso = ?1 ORDER BY a.nome")
	List<Aluno> findAlunosByCurso(String curso);
}
