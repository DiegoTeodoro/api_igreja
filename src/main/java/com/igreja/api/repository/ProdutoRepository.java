package com.igreja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igreja.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
