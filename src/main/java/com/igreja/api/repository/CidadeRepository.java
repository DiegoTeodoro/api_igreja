package com.igreja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igreja.api.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
