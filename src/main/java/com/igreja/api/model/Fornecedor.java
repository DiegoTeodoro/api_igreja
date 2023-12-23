package com.igreja.api.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "fornecedor")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull
	private String cpfCnpj;
	
	@NotNull
	private String razaoSocial;
	
	private String nomeFantasia;

	private String inscriçãoEstadual;

	private String inscriçãoMunicipal;

	private Integer tipo;

	private String email;

	private String telFixo;

	private String celular;

	@Embedded
	private Endereco endereco;

	@NotNull
	private Boolean ativo;

	public Fornecedor() {

	}

	public Fornecedor(Long codigo, @NotNull String cpfCnpj, @NotNull String razaoSocial, String nomeFantasia,
			String inscriçãoEstadual, String inscriçãoMunicipal, Integer tipo, String email, String telFixo,
			String celular, Endereco endereco, @NotNull Boolean ativo) {
		super();
		this.codigo = codigo;
		this.cpfCnpj = cpfCnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.inscriçãoEstadual = inscriçãoEstadual;
		this.inscriçãoMunicipal = inscriçãoMunicipal;
		this.tipo = tipo;
		this.email = email;
		this.telFixo = telFixo;
		this.celular = celular;
		this.endereco = endereco;
		this.ativo = ativo;
	}



	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getInscriçãoEstadual() {
		return inscriçãoEstadual;
	}

	public void setInscriçãoEstadual(String inscriçãoEstadual) {
		this.inscriçãoEstadual = inscriçãoEstadual;
	}

	public String getInscriçãoMunicipal() {
		return inscriçãoMunicipal;
	}

	public void setInscriçãoMunicipal(String inscriçãoMunicipal) {
		this.inscriçãoMunicipal = inscriçãoMunicipal;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
