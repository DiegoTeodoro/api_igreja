package com.igreja.api.model;

public enum PedidoStatus {
	ESPERANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);


	private int codigo;
	
	PedidoStatus(int codigo) {
		this.codigo = codigo;
	}
	
	public int getcodigo() {
		return codigo;
	}
	
	public static PedidoStatus valueOf(int codigo) {
		for(PedidoStatus valor : PedidoStatus.values()) {
			if(valor.getcodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("código de pedido inválido");
		
	}

}
