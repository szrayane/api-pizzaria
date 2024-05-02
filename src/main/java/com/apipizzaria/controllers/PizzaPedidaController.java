package com.apipizzaria.controllers;
import com.apipizzaria.models.dtos.PizzaPedidaDTO;
import com.apipizzaria.services.PizzaPedidaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/pizza-pedida")
public class PizzaPedidaController {

    private final PizzaPedidaService pizzaPedidaService;

    @GetMapping("/mostrar")
    public List<PizzaPedidaDTO> findAll(){
        return pizzaPedidaService.findAll();
    }

    @PostMapping("/salvar/{clienteId}")
    public PizzaPedidaDTO save(@RequestBody PizzaPedidaDTO pizzaPedidaDTO, @PathVariable UUID clienteId) {
        return pizzaPedidaService.save(pizzaPedidaDTO, clienteId);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete (@PathVariable long id){
        pizzaPedidaService.delete(id);
    }

    @PutMapping("/alterar/{id}")
    public void update (@PathVariable long id, @RequestBody PizzaPedidaDTO pizzaPedidaDTO){
        pizzaPedidaService.update(id, pizzaPedidaDTO);
    }
}
