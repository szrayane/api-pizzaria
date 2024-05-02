package com.apipizzaria.controllers;

import com.apipizzaria.models.dtos.IngredienteDTO;
import com.apipizzaria.services.IngredienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/ingrediente")
public class IngredienteController {

    private final IngredienteService ingredienteService;

    @GetMapping("/mostrar")
    public List<IngredienteDTO> findAll(){
        return ingredienteService.findAll();
    }

    @PostMapping("/salvar")
    public IngredienteDTO save(@RequestBody IngredienteDTO ingrediente){
        return ingredienteService.save(ingrediente);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete (@PathVariable long id){
        ingredienteService.deleteById(id);
    }

    @PutMapping("/atualizar/{id}")
    public void update (@PathVariable long id, @RequestBody IngredienteDTO ingrediente){
        ingredienteService.update(id,ingrediente);
    }
}
