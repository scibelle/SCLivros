package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.models.Produto;
import com.example.repository.ProdutoRespository;
import com.example.utils.Utils;


@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRespository prodRepository;	
	
	public void adicionarProduto(Produto produto, MultipartFile imagem) {
		String caminho = "imagem/" + produto.getNome() + ".jpg";
		Utils.salvarImagem(caminho,imagem);
		
		prodRepository.save(produto);

	}

	public List<Produto> retornarTodosOsProdutos() {
		
		return prodRepository.findAll();
	}
	
	public Produto buscarPorId(Long id) {
		return prodRepository.getOne(id);
	}


	
	public void excluirProduto(Long id) {
		prodRepository.deleteById(id);
		
	}
	

}
