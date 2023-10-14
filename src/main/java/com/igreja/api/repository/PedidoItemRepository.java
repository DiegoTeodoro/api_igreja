package com.igreja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igreja.api.model.PedidoItem;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

}
