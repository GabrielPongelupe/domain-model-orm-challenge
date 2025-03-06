package com.domain_model_orm_challeng.domain_model_orm.controllers;

import com.domain_model_orm_challeng.domain_model_orm.entities.Bloco;
import com.domain_model_orm_challeng.domain_model_orm.services.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bloco")
public class BlocoController {
    @Autowired
    private BlocoService blocoService;

    @GetMapping("/{id}")
    public Bloco findById(@PathVariable("id") Integer id) {
        return blocoService.findById(id);
    }

    @PostMapping
    public Bloco create(@RequestBody Bloco bloco) {
        return blocoService.create(bloco);
    }

    @PutMapping("/{id}")
    public Bloco update(@PathVariable("id") Integer id, @RequestBody Bloco bloco) {
        bloco.setId(id);
        return blocoService.update(bloco);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        blocoService.delete(id);
    }
}
