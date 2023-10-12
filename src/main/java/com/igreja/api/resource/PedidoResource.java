package com.igreja.api.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igreja.api.model.Pedido;
import com.igreja.api.repository.PedidoRepository;

@RestController
@RequestMapping("pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoRepository pedidoService;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> Listar(){
		List<Pedido> list = pedidoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Optional<Pedido>> buscarPeloCodigo(@PathVariable Long codigo){
		Optional<Pedido> pedido = pedidoService.findById(codigo);
		return ResponseEntity.ok().body(pedido);
	}

}
