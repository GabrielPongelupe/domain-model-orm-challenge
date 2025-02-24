package com.domain_model_orm_challeng.domain_model_orm.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Atividade> atividades = new ArrayList<>();

    // Construtor padrão (sem parâmetros)
    public Categoria() {
    }

    // Construtor com parâmetros
    public Categoria(String descricao, List<Atividade> atividades) {
        this.descricao = descricao;
        this.atividades = atividades;
    }

    // Getter e Setter para id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter e Setter para descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter e Setter para atividades
    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    // Equals e HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ToString (opcional)
    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", atividades=" + atividades +
                '}';
    }
}
