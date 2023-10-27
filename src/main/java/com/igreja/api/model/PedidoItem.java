package com.igreja.api.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.igreja.api.model.pk.PedidoItemPK;

@Entity
@Table(name = "pedido_item")
public class PedidoItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PedidoItemPK codigo = new PedidoItemPK();

	private Integer quantidade;
	private Double preço;

	public PedidoItem() {

	}

	public PedidoItem(Pedido pedido, Produto produto, Integer quantidade, Double preço) {
		codigo.setPedido(pedido);
		codigo.setProduto(produto);
		this.quantidade = quantidade;
		this.preço = preço;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return codigo.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		codigo.setPedido(pedido);
	}
	
	@JsonIgnore
	public Produto getProduto() {
		return codigo.getProduto();
	}
	
	public void setProduto(Produto produto) {
		codigo.setProduto(produto);
	}

	public PedidoItemPK getCodigo() {
		return codigo;
	}

	public void setCodigo(PedidoItemPK codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreço() {
		return preço;
	}

	public void setPreço(Double preço) {
		this.preço = preço;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItem other = (PedidoItem) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
