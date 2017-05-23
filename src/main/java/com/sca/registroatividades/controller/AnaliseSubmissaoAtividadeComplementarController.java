package com.sca.registroatividades.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sca.registroatividades.model.Aluno;
import com.sca.registroatividades.service.AnaliseRegistrosAtividadeService;

@Controller
@RequestMapping("/analiseAtividades")
public class AnaliseSubmissaoAtividadeComplementarController {

	@Autowired
	AnaliseRegistrosAtividadeService service;
	
	@RequestMapping(value = "/homeAnalise", method = RequestMethod.GET)
	public ModelAndView paginaInicialAnalise(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/analiseRegistros.jsp");
		List<Aluno> atividades = service.homeAnaliseAtividades("1111111");
		//System.out.println(atividades); // OK
		model.addObject("atividades", atividades);
		return model;
	}
	
	@RequestMapping(value = "/homeAnalise/aprovar/{id}", method = RequestMethod.POST)
	public String aprovarAnalise(@PathVariable String id){
		System.out.println(id);
		return "/analiseAtividades/homeAnalise";
	}
	
	@RequestMapping(value = "/homeAnalise/recusar/{id}", method = RequestMethod.POST)
	public String recusarAnalise(@PathVariable String id, @RequestParam String justificativa){
		System.out.println(id);
		System.out.println(justificativa);
		return "/analiseAtividades/homeAnalise";
	}
}
