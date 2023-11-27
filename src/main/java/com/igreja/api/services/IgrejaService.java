package com.igreja.api.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.igreja.api.model.Igreja;
import com.igreja.api.repository.IgrejaRepository;
import com.igreja.api.resource.exepctions.DatabaseException;
import com.igreja.api.services.exceptions.ResourceNotFoundException;

@Service
public class IgrejaService {

	@Autowired
	private IgrejaRepository igrejaRepository;

	public List<Igreja> listar() {
		return igrejaRepository.findAll();
	}

	public Igreja buscarPeloCodigo(Long codigo) {
		Optional<Igreja> igreja = igrejaRepository.findById(codigo);
		return igreja.orElseThrow(() -> new ResourceNotFoundException(codigo));

	}

	public Igreja salvar(Igreja igreja) {
		return igrejaRepository.save(igreja);

	}

	public void remover(Long codigo) {
		try {
			igrejaRepository.deleteById(codigo);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(codigo);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public Igreja atualizar(Long codigo, Igreja igreja) {
		try {
			Igreja igrejaSalva = buscarIgrejaPeloCodigo(codigo);
			BeanUtils.copyProperties(igreja, igrejaSalva, "codigo");
			return igrejaRepository.save(igreja);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(codigo);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(codigo);
		}
		
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