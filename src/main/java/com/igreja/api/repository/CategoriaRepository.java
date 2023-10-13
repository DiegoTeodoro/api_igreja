package com.igreja.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igreja.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
