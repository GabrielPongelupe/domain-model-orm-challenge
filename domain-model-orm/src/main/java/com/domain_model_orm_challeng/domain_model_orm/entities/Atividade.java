package com.domain_model_orm_challeng.domain_model_orm.entities;

import jakarta.persistence.*;
import java.util.Objects;
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

    // Construtor padrão (sem parâmetros)
    public Atividade() {
    }

    // Construtor com parâmetros
    public Atividade(String nome, String descricao, Double preco, Set<Participante> participantes, Set<Bloco> blocos, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.participantes = participantes;
        this.blocos = blocos;
        this.categoria = categoria;
    }

    // Getter e Setter para id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter e Setter para preco
    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // Getter e Setter para participantes
    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    // Getter e Setter para blocos
    public Set<Bloco> getBlocos() {
        return blocos;
    }

    public void setBlocos(Set<Bloco> blocos) {
        this.blocos = blocos;
    }

    // Getter e Setter para categoria
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // Equals e HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(id, atividade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ToString (opcional)
    @Override
    public String toString() {
        return "Atividade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", participantes=" + participantes +
                ", blocos=" + blocos +
                ", categoria=" + categoria +
                '}';
    }
}
