package com.igreja.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.api.model.Produto;
import com.igreja.api.repository.ProdutoRepository;

@RestController
@RequestMapping("produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produto>> Listar(){
		List<Produto> list = produtoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Produto>> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Produto> produto = produtoService.findById(codigo);
		return ResponseEntity.ok().body(produto);
	}

}
