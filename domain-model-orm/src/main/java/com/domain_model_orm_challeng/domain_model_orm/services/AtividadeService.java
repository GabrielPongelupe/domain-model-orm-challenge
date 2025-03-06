package com.domain_model_orm_challeng.domain_model_orm.services;

import com.domain_model_orm_challeng.domain_model_orm.entities.Atividade;
import com.domain_model_orm_challeng.domain_model_orm.repositories.AtividadeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;


    public Atividade findById(Integer id) {
        return atividadeRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Atividade não encontrada"));

    }

    @Transactional
    public Atividade create(Atividade atividade){
        return atividadeRepository.save(atividade);
    }

    @Transactional
    public Atividade update(Atividade atividade) {
        Atividade atividadeToUpdate = findById(atividade.getId());


        if (atividade.getNome() != null) {
            atividadeToUpdate.setNome(atividade.getNome());
        }

        if (atividade.getDescricao() != null) {
            atividadeToUpdate.setDescricao(atividade.getDescricao());
        }

        if (atividade.getPreco() != null) {
            atividadeToUpdate.setPreco(atividade.getPreco());
        }

        if (atividade.getCategoria() != null) {
            atividadeToUpdate.setCategoria(atividade.getCategoria());
        }

        if (atividade.getParticipantes() != null) {
            atividadeToUpdate.setParticipantes(atividade.getParticipantes());
        }

        if (atividade.getBlocos() != null) {
            atividadeToUpdate.setBlocos(atividade.getBlocos());
        }

        return atividadeRepository.save(atividadeToUpdate);

    }

    @Transactional
    public void delete(Integer id) {
        atividadeRepository.deleteById(id);
    }
}
