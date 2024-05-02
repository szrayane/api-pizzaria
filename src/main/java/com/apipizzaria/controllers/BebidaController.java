package com.apipizzaria.controllers;
import com.apipizzaria.models.dtos.BebidaDTO;
import com.apipizzaria.services.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/bebidas")
@RestController
public class BebidaController {

    private final BebidaService bebidaService;

    @Autowired
    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @GetMapping("/mostrar")
    public List<BebidaDTO> findAll() {
        return bebidaService.findAll();
    }

    @PostMapping("/salvar")
    public BebidaDTO save(@RequestBody BebidaDTO bebida) {
        return bebidaService.save(bebida);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable Long id) {
        bebidaService.deleteById(id);
    }

    @PutMapping("/atualizar/{id}")
    public void update(@PathVariable Long id, @RequestBody BebidaDTO bebidaAtualizada) {
        bebidaService.update(id, bebidaAtualizada);
    }
}
