package com.igreja.api.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object codigo) {
		super("Codigo não encontrado: " + codigo);
	}

}
