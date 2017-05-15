package com.sca.registroatividades.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sca.registroatividades.model.Professor;
import com.sca.registroatividades.repository.AlunoRepository;
import com.sca.registroatividades.repository.ProfessorRepository;

@Controller
@RequestMapping("/cadastrar")
public class CadastrarController {
	
	@Autowired
	ProfessorRepository profDao;
	
	@Autowired
	AlunoRepository alunoDao;
	
	@RequestMapping(value = "/professor", method = RequestMethod.POST)
	public ModelAndView cadastrarProfessor(@RequestParam
			String nome,
			String matricula,
			String curso1,
			String curso2) {
		
		List<String> cursos = new ArrayList<>();
		cursos.add(curso1);
		cursos.add(curso2);
		
		Professor p = new Professor(matricula, cursos, nome);
		profDao.save(p);
		ModelAndView mv = new ModelAndView("professor.jsp");
		mv.addObject("msg", "Professor adicionado com sucesso");
		return mv;
	}
	
	@RequestMapping(value = "/aluno", method = RequestMethod.POST)
	public ModelAndView cadastrarAluno(@RequestParam
			String nome,
			String matricula,
			String curso,
			String tipoAtividade,
			String categoria,
			String cargaHoraria,
			File file) {
		
		byte[] bFile = new byte[(int) file.length()];
		//precisa ler o arquivo para salvar no banco
		
		ModelAndView mv = new ModelAndView("aluno.jsp");
		mv.addObject("msg", "Aluno adicionado com sucesso");
		return mv;
	}

}
