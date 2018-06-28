package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Pessoa;
import com.example.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@RequestMapping("/formulario")
	public ModelAndView formularioPessoa() {
		ModelAndView mv = new ModelAndView("paginas/pessoas/formPessoa");
		mv.addObject("pessoa", new Pessoa());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarPessoa(Pessoa pessoa) {
		pessoaService.adicionarPessoa(pessoa);
		ModelAndView mv = new ModelAndView("redirect:/suc");

		
		return mv;
	}
	
	@GetMapping("/listar")
	public ModelAndView listarPessoa() {
		List<Pessoa> pessoas = pessoaService.TodasAsPessoas();
		ModelAndView mv = new ModelAndView("paginas/pL");
		
		mv.addObject("todasAsPessoas", pessoas);
		
		return mv;
	}
	
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirPessoa(@PathVariable Long id) {
		pessoaService.removerPessoa(id);
		ModelAndView mv = new ModelAndView("redirect:/paginaInicial");
		return mv;
	}
	
	
	@RequestMapping("/logar")
	public ModelAndView logar() {
		ModelAndView mv = new ModelAndView("paginas/login");
		return mv;
	}	
	

}
