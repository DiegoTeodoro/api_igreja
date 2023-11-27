package com.igreja.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.api.model.Produto;
import com.igreja.api.repository.ProdutoRepository;
import com.igreja.api.services.ProdutoService;

@RestController
@RequestMapping("produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> Listar(){
		List<Produto> list = produtoService.listar();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long codigo){
		Produto produto = produtoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok().body(produto);
	}

}
