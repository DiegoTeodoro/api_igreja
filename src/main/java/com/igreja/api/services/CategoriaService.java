package com.igreja.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igreja.api.model.Categoria;
import com.igreja.api.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	public Categoria buscarPeloCodigo(Long codigo) {
		Optional<Categoria> obj = categoriaRepository.findById(codigo);
		return obj.get();
	}

}
