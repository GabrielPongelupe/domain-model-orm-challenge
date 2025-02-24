package com.domain_model_orm_challeng.domain_model_orm.repositories;

import com.domain_model_orm_challeng.domain_model_orm.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {
}
