package com.igreja.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.api.model.Categoria;
import com.igreja.api.repository.CategoriaRepository;

@RestController
@RequestMapping("Categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaRepository setorService;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> Listar(){
		List<Categoria> list = setorService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Categoria>> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Categoria> categoria = setorService.findById(codigo);
		return ResponseEntity.ok().body(categoria);
	}

}
