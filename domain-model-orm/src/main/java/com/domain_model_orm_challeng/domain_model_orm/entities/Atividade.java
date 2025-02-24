package com.domain_model_orm_challeng.domain_model_orm.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String descricao;

    private Double preco;

    @ManyToMany
    @JoinTable(name = "tb_participantes_atividade",
            joinColumns = @JoinColumn(name = "atividade_id"),
            inverseJoinColumns = @JoinColumn(name = "participante_id"))
    private Set<Participante> participantes;

    @OneToMany(mappedBy = "atividade")
    private Set<Bloco> blocos;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
