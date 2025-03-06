package com.domain_model_orm_challeng.domain_model_orm.services;

import com.domain_model_orm_challeng.domain_model_orm.entities.Participante;
import com.domain_model_orm_challeng.domain_model_orm.repositories.ParticipanteRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {
    @Autowired
    private ParticipanteRepository participanteRepository;

    @Transactional
    public Participante findById(Integer id){
        Participante participante = participanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Participante não encontrado"));
        participante.getAtividades().size();
        return participante;
    }

    @Transactional
    public Participante update(@NonNull Participante participante) {
        Participante participanteToUpdate = findById(participante.getId());

        participanteToUpdate.setNome(participante.getNome());
        participanteToUpdate.setEmail(participante.getEmail());
        participanteToUpdate.setAtividades(participante.getAtividades());

        return participanteRepository.save(participanteToUpdate);
    }

    @Transactional
    public void deleteById(Integer id) {
        Participante participante = findById(id);

        participanteRepository.delete(participante);
    }

    @Transactional
    public Participante create(@NonNull Participante participante) {
        return participanteRepository.save(participante);
    }

}
