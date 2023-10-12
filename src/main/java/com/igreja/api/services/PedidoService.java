package com.igreja.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igreja.api.model.Pedido;
import com.igreja.api.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> listar(){
		return  pedidoRepository.findAll();
	}
	
	public Pedido buscarPeloCodigo(Long codigo) {
		Optional<Pedido> obj =  pedidoRepository.findById(codigo);
		return obj.get();
	}

}
