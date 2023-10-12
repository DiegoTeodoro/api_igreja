package com.igreja.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.api.model.Igreja;
import com.igreja.api.repository.IgrejaRepository;

@RestController
@RequestMapping("igrejas")
public class IgrejaResource {
	
	@Autowired
	private IgrejaRepository igrejaService;
	
	@GetMapping
	public ResponseEntity<List<Igreja>> Listar(){
		List<Igreja> list = igrejaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Igreja>> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Igreja> igreja = igrejaService.findById(codigo);
		return ResponseEntity.ok().body(igreja);
	}

}
