package com.domain_model_orm_challeng.domain_model_orm.services;

import com.domain_model_orm_challeng.domain_model_orm.entities.Categoria;
import com.domain_model_orm_challeng.domain_model_orm.repositories.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Buscar categoria pelo ID
    public Categoria findById(Integer id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com o ID: " + id));
    }

    // Criar uma nova categoria
    @Transactional
    public Categoria create(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Atualizar uma categoria existente
    @Transactional
    public void update(Categoria categoria) {
        Categoria categoriaToUpdate = findById(categoria.getId());

        if (categoria.getDescricao() != null) {
            categoriaToUpdate.setDescricao(categoria.getDescricao());
        }

        if (categoria.getAtividades() != null && !categoria.getAtividades().isEmpty()) {
            categoriaToUpdate.setAtividades(categoria.getAtividades());
        }

        categoriaRepository.save(categoriaToUpdate);
    }

    // Deletar uma categoria pelo ID
    @Transactional
    public void delete(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
