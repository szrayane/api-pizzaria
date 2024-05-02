package com.apipizzaria.controllers;

import com.apipizzaria.models.dtos.PizzaIngredienteDTO;
import com.apipizzaria.services.PizzaIngredienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pizza-ingrediente") // Endpoint alterado para evitar conflito
public class PizzaIngredienteController {

    private final PizzaIngredienteService pizzaIngredienteService;

    @GetMapping("/mostrar")
    public List<PizzaIngredienteDTO> findAll() {
        return pizzaIngredienteService.findAll();
    }

    @PostMapping("/salvar")
    public PizzaIngredienteDTO save(@RequestBody PizzaIngredienteDTO pizzaIngredienteDTO) {
        return pizzaIngredienteService.save(pizzaIngredienteDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable long id) {
        pizzaIngredienteService.deleteById(id);
    }

    @PutMapping("/atualizar/{id}")
    public void update(@PathVariable long id, @RequestBody PizzaIngredienteDTO pizzaIngredienteDTO){
        pizzaIngredienteService.update(id, pizzaIngredienteDTO);
    }
}
