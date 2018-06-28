package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("paginas/login");
		return mv;
	}	
	
	@RequestMapping("/suc")
	public String sucesso() {
		return "paginas/sucesso";
	}
		

	@RequestMapping("/paginaInicial")
	public String index() {
		
		return "paginas/paginaInicial";
	}
	
	@RequestMapping("/index")
	public String index1(){
		
		return "index";
	}
	
	@RequestMapping("/sobrenos")
	public String index2() {
		
		return "paginas/sobrenos";
	}
	
	@RequestMapping("/contato")
	public String index3() {
		
		return "paginas/contato";
	}
	
	@RequestMapping("/produto/listar")
	public String index6() {
		
		return "paginas/produto/listar";
	}
	
	@RequestMapping("/cadastro")
	public String index5() {
		
		return "paginas/pessoas/formPessoa";
	}
	
}
