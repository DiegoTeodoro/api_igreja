package com.igreja.api.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igreja.api.model.Fornecedor;
import com.igreja.api.repository.FornecedorRepository;
import com.igreja.api.services.FornecedorService;

@RestController
@RequestMapping("fornecedores")
public class FornecedorResource {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping
	public ResponseEntity<List<Fornecedor>> Listar() {
		List<Fornecedor> list = fornecedorService.listar();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Fornecedor> buscarPeloCodigo(@PathVariable Long codigo) {
		Fornecedor fornecedor =fornecedorService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok().body(fornecedor);
		
	}

	@PostMapping
	public ResponseEntity<Fornecedor> salvar(@RequestBody Fornecedor fornecedor) {
		fornecedor = fornecedorService.salvar(fornecedor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
				.buildAndExpand(fornecedor.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(fornecedor);
	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable Long codigo) {
		fornecedorService.remover(codigo);
		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Fornecedor> atualizar(@PathVariable Long codigo, @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorSalvo = fornecedorService.atualizar(codigo, fornecedor);
		return ResponseEntity.ok(fornecedorSalvo);
	}

}
