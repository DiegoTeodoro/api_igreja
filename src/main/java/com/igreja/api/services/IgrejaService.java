package com.igreja.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igreja.api.model.Igreja;
import com.igreja.api.repository.IgrejaRepository;

@Service
public class IgrejaService {
	
	@Autowired
	private IgrejaRepository igrejaRepository;
	
	public List<Igreja> listar(){
		return  igrejaRepository.findAll();
	}
	
	public Igreja buscarPeloCodigo(Long codigo) {
		Optional<Igreja> obj =  igrejaRepository.findById(codigo);
		return obj.get();
	}

}
