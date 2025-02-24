package com.domain_model_orm_challeng.domain_model_orm.services;


import com.domain_model_orm_challeng.domain_model_orm.entities.Bloco;
import com.domain_model_orm_challeng.domain_model_orm.repositories.BlocoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlocoService {
    @Autowired
    private BlocoRepository blocoRepository;

    public Bloco findById(Integer id) {
        return  blocoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Bloco não encontrado"));
    }

    @Transactional
    public void create(Bloco bloco) {
        blocoRepository.save(bloco);
    }

    @Transactional
    public void update(Bloco bloco) {
        Bloco blocoToUpdate = findById(bloco.getId());

        if (bloco.getInicio() != null) {
            blocoToUpdate.setInicio(bloco.getInicio());
        }

        if (bloco.getFim() != null) {
            blocoToUpdate.setFim(bloco.getFim());
        }

        if (bloco.getAtividade() != null) {
            blocoToUpdate.setAtividade(bloco.getAtividade());
        }

        blocoRepository.save(blocoToUpdate);
    }

    @Transactional
    public void delete(Integer id) {
        blocoRepository.deleteById(id);
    }

}
