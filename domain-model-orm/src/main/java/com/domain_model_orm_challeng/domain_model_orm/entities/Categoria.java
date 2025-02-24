package com.domain_model_orm_challeng.domain_model_orm.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;


    @OneToMany(mappedBy = "categoria")
    private List<Atividade> atividades = new ArrayList<>();

}
