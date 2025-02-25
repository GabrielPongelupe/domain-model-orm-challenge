package com.domain_model_orm_challeng.domain_model_orm.controllers;

import com.domain_model_orm_challeng.domain_model_orm.entities.Atividade;
import com.domain_model_orm_challeng.domain_model_orm.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
    @Autowired
    private AtividadeService atividadeService;

    @GetMapping("/{id}")
    public Atividade findById(@PathVariable("id") Integer id) {
        return atividadeService.findById(id);
    }

    @PostMapping
    public Atividade save(@RequestBody Atividade atividade) {
        return atividadeService.create(atividade);
    }

    @PutMapping("{id}")
    public Atividade update(@PathVariable("id") Integer id, @RequestBody Atividade atividade) {
        atividade.setId(id);
        return atividadeService.update(atividade);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        atividadeService.delete(id);
    }
}
