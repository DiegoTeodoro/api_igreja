package com.igreja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igreja.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
