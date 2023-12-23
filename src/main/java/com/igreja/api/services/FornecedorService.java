package com.igreja.api.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.igreja.api.model.Fornecedor;
import com.igreja.api.model.Igreja;
import com.igreja.api.repository.FornecedorRepository;
import com.igreja.api.resource.exepctions.DatabaseException;
import com.igreja.api.services.exceptions.ResourceNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public List<Fornecedor> listar() {
		return fornecedorRepository.findAll();
	}

	public Fornecedor buscarPeloCodigo(Long codigo) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(codigo);
		return fornecedor.orElseThrow(() -> new ResourceNotFoundException(codigo));

	}

	public Fornecedor salvar(Fornecedor igreja) {
		return fornecedorRepository.save(igreja);

	}

	public void remover(Long codigo) {
		try {
			fornecedorRepository.deleteById(codigo);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(codigo);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public Fornecedor atualizar(Long codigo, Fornecedor fornecedor) {
		try {
			Fornecedor fornecedorSalvo = buscarFornecedorPeloCodigo(codigo);
			BeanUtils.copyProperties(fornecedor, fornecedorSalvo, "codigo");
			return fornecedorRepository.save(fornecedor);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(codigo);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(codigo);
		}
		
	}

	public Fornecedor buscarFornecedorPeloCodigo(Long codigo) {
		Fornecedor fornecedorSalvo = fornecedorRepository.findById(codigo).orElseThrow(() -> new EmptyResultDataAccessException(1));
		return fornecedorSalvo;
	}
	
	public void atualizarPropriedadeAtivo(Long codigo, Boolean ativo) {
		Fornecedor fornecedorSalvo = buscarFornecedorPeloCodigo(codigo);
		fornecedorSalvo.setAtivo(ativo);
		fornecedorRepository.save(fornecedorSalvo);
	}
}