package com.domain_model_orm_challeng.domain_model_orm.controllers;

import com.domain_model_orm_challeng.domain_model_orm.entities.Participante;
import com.domain_model_orm_challeng.domain_model_orm.services.ParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {
    @Autowired
    private ParticipanteService participanteService;

    @PostMapping
    public Participante create(@RequestBody Participante participante) {
        return participanteService.create(participante);
    }

    @PutMapping("/{id}")
    public Participante update(@PathVariable Integer id, @RequestBody Participante participante) {
        participante.setId(id);
        return participanteService.update(participante);
    }

    @GetMapping("/{id}")
    public Participante findById(@PathVariable Integer id) {
        return participanteService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        participanteService.deleteById(id);
    }
}
