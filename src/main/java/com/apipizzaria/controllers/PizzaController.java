package com.apipizzaria.controllers;
import com.apipizzaria.models.dtos.PizzaDTO;
import com.apipizzaria.services.PizzaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaService pizzaService;

    @GetMapping("/mostrar")
    public List<PizzaDTO> findAll() {
        return pizzaService.findAll();
    }

    @PostMapping("/salvar")
    public PizzaDTO save(@RequestBody PizzaDTO pizzaDTO) {
        return pizzaService.save(pizzaDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete (@PathVariable long id){
    pizzaService.deleteById(id);
    }

    @PutMapping("atualizar/{id}")
    public void update(@PathVariable long id, @RequestBody PizzaDTO pizzaDTO){
    pizzaService.update(id, pizzaDTO);
    }
}
