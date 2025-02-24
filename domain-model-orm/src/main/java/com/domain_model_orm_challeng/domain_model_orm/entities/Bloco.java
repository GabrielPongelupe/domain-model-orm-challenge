package com.domain_model_orm_challeng.domain_model_orm.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_bloco")
public class Bloco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant inicio;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant fim;

    @ManyToOne
    @JoinColumn(name = "atividade_id")
    private Atividade atividade;

    // Construtor padrão (sem parâmetros)
    public Bloco() {
    }

    // Construtor com parâmetros
    public Bloco(Integer id, Instant inicio, Instant fim, Atividade atividade) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.atividade = atividade;
    }

    // Getter e Setter para id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter e Setter para inicio
    public Instant getInicio() {
        return inicio;
    }

    public void setInicio(Instant inicio) {
        this.inicio = inicio;
    }

    // Getter e Setter para fim
    public Instant getFim() {
        return fim;
    }

    public void setFim(Instant fim) {
        this.fim = fim;
    }

    // Getter e Setter para atividade
    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    // Equals e HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bloco bloco = (Bloco) o;
        return Objects.equals(id, bloco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // ToString (opcional, mas útil para depuração)
    @Override
    public String toString() {
        return "Bloco{" +
                "id=" + id +
                ", inicio=" + inicio +
                ", fim=" + fim +
                ", atividade=" + atividade +
                '}';
    }
}
