package com.sca.registroatividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sca.registroatividades.model.Aluno;
import com.sca.registroatividades.service.AnaliseRegistrosAtividadeService;

@Controller
@RequestMapping("/analiseAtividades")
public class AnaliseSubmissaoAtividadeComplementarController {

	@Autowired
	AnaliseRegistrosAtividadeService service;
	
	@RequestMapping(value = "/homeAnalise", method = RequestMethod.GET)
	public ModelAndView paginaInicialAnalise(){
		ModelAndView model = new ModelAndView("analiseRegistros.jsp");
		
		List<Aluno> atividades = service.homeAnaliseAtividades("1111");
		model.addObject("atividades", atividades);
		return model;
	}
}
