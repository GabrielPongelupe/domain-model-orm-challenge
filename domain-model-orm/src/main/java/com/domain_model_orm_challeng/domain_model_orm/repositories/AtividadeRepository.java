package com.domain_model_orm_challeng.domain_model_orm.repositories;

import com.domain_model_orm_challeng.domain_model_orm.entities.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
}
