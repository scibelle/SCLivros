package com.example.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Produto;
import com.example.service.ProdutoService;


@Controller
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@RequestMapping("/formulario")
	public ModelAndView formularioProduto() {
		ModelAndView mv = new ModelAndView("paginas/produtos/formProduto");
		mv.addObject("produto", new Produto());
		return mv;
	}


	
	@PostMapping("/salvar")
	public ModelAndView salvarProduto(Produto produto, @RequestParam(value= "imagem") MultipartFile imagem) {
		produtoService.adicionarProduto(produto,imagem);
		ModelAndView mv = new ModelAndView("redirect:/produto/formulario");
		return mv;
		
	}
	 	
		
	@GetMapping("/listar")
	public ModelAndView listarProdutos() {
		List<Produto> produtos = produtoService.retornarTodosOsProdutos();
		ModelAndView mv = new ModelAndView("/paginas/produtos/pagina-listagemClientes");
		mv.addObject("todosOsProdutos", produtos);
		
		return mv;
	}
	
	@GetMapping("/listarAdm")
	public ModelAndView listarProdutosAdm() {
		List<Produto> produtos = produtoService.retornarTodosOsProdutos();
		ModelAndView mv = new ModelAndView("/paginas/produtos/pagina-listagem");
		mv.addObject("todosOsProdutos", produtos);
		
		return mv;
	}
	
	
	@RequestMapping(value="{id}")
	public ModelAndView atualizarProduto(@PathVariable Long id) {
		Produto produto = produtoService.buscarPorId(id);
		ModelAndView mv = new ModelAndView("/produto/formulario");
		mv.addObject("produto", produto);
		
		return mv;
	}
	
	
	@RequestMapping("/excluir/{id}")
	public ModelAndView excluirProduto(@PathVariable Long id) {
		produtoService.excluirProduto(id);
		ModelAndView mv = new ModelAndView("redirect:/produto/listarAdm");
		return mv;
	}

	@RequestMapping("/promocoes")
	public  ModelAndView promocoesProdutos() {
		List <Produto> produto=  produtoService.retornarTodosOsProdutos();
		ModelAndView mv = ModelAndView("/paginas/promocoes");
		mv.addObject("TodosOsProdutos",produto);
		return mv;
	}



	private ModelAndView ModelAndView(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
