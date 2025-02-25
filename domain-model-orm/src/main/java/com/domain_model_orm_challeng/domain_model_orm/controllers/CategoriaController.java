package com.domain_model_orm_challeng.domain_model_orm.controllers;

import com.domain_model_orm_challeng.domain_model_orm.entities.Categoria;
import com.domain_model_orm_challeng.domain_model_orm.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria) {
        return categoriaService.create(categoria);
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Integer id) {
        return categoriaService.findById(id);
    }

    @PutMapping("/{id}")
    public Categoria update(@PathVariable("id") Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        return categoriaService.update(categoria);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {
        categoriaService.delete(id);
    }

}
