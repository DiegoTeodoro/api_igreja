package com.igreja.api.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Igreja> salvar(@RequestBody Igreja igreja){
		igreja = igrejaService.save(igreja);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(igreja.getCodigo()).toUri();
		
		return ResponseEntity.created(uri).body(igreja);
	}

}
