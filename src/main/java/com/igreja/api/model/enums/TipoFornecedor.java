package com.igreja.api.model.enums;

public enum TipoFornecedor {
	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica"); 
	
	private int codigo;
	private String descricao; 


	private TipoFornecedor(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoFornecedor toEnum(int codigo) {
		for(TipoFornecedor value : TipoFornecedor.values()) {
			if(value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("código do fornecedor inválido");
	}


	
	
	
	
}
