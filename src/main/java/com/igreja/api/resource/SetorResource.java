package com.igreja.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.api.model.Setor;
import com.igreja.api.repository.SetorRepository;

@RestController
@RequestMapping("setor")
public class SetorResource {
	
	@Autowired
	private SetorRepository setorService;
	
	@GetMapping
	public ResponseEntity<List<Setor>> Listar(){
		List<Setor> list = setorService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Setor>> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Setor> setor = setorService.findById(codigo);
		return ResponseEntity.ok().body(setor);
	}

}
