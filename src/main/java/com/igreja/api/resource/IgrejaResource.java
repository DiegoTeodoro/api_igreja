package com.igreja.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igreja.api.model.Igreja;
import com.igreja.api.repository.IgrejaRepository;
import com.igreja.api.services.IgrejaService;

@RestController
@RequestMapping("igrejas")
public class IgrejaResource {

	@Autowired
	private IgrejaRepository igrejaRepository;
	
	@Autowired
	private IgrejaService igrejaService;

	@GetMapping
	public ResponseEntity<List<Igreja>> Listar() {
		List<Igreja> list = igrejaService.listar();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Igreja> buscarPeloCodigo(@PathVariable Long codigo) {
		Igreja igreja = igrejaService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok().body(igreja);
		
	}

	@PostMapping
	public ResponseEntity<Igreja> salvar(@RequestBody Igreja igreja) {
		igreja = igrejaService.salvar(igreja);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(igreja.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(igreja);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable Long codigo) {
		igrejaService.remover(codigo);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Igreja> atualizar(@PathVariable Long codigo, @RequestBody Igreja igreja) {
		Igreja igrejaSalva = igrejaService.atualizar(codigo, igreja);
		return ResponseEntity.ok(igrejaSalva);
	}

	@PutMapping("/{codigo}/ativo")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void atualizarPropriedadeAtivo(@PathVariable Long codigo, @RequestBody Boolean ativo) {
		igrejaService.atualizarPropriedadeAtivo(codigo, ativo);
	}
}
