package com.igreja.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igreja.api.model.Produto;
import com.igreja.api.repository.ProdutoRepository;
import com.igreja.api.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	
	public Produto buscarPeloCodigo(Long codigo) {
		Optional<Produto> produto = produtoRepository.findById(codigo);
		return produto.orElseThrow(() -> new ResourceNotFoundException(codigo));

	}

}
