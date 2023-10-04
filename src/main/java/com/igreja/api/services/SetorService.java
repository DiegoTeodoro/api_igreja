package com.igreja.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igreja.api.model.Setor;
import com.igreja.api.repository.SetorRepository;

@Service
public class SetorService {
	
	@Autowired
	private SetorRepository setorRepository;
	
	public List<Setor> listar(){
		return setorRepository.findAll();
	}
	
	public Setor buscarPeloCodigo(Long codigo) {
		Optional<Setor> obj = setorRepository.findById(codigo);
		return obj.get();
	}

}
