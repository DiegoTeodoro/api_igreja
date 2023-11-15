package com.igreja.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.igreja.api.model.Igreja;
import com.igreja.api.repository.IgrejaRepository;

@Service
public class IgrejaService {

	@Autowired
	private IgrejaRepository igrejaRepository;

	public List<Igreja> listar() {
		return igrejaRepository.findAll();
	}

	public Igreja buscarPeloCodigo(Long codigo) {
		Optional<Igreja> obj = igrejaRepository.findById(codigo);
		return obj.get();
	}

	public Igreja salvar(Igreja igreja) {
		return igrejaRepository.save(igreja);

	}

	public void delete(Long codigo) {
		igrejaRepository.deleteById(codigo);
	}

	public Igreja atualizar(Long codigo, Igreja igreja) {
		Igreja igrejaSalva = buscarIgrejaPeloCodigo(codigo);
		BeanUtils.copyProperties(igreja, igrejaSalva, "codigo");
		return igrejaRepository.save(igreja);
	}

	public Igreja buscarIgrejaPeloCodigo(Long codigo) {
		Igreja igrejaSalva = igrejaRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return igrejaSalva;
	}
	
	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Igreja igrejaSalva = buscarIgrejaPeloCodigo(codigo);
		igrejaSalva.setAtivo(ativo);
		igrejaRepository.save(igrejaSalva);
	}
}