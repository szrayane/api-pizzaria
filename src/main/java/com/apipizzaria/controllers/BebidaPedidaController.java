package com.apipizzaria.controllers;
import com.apipizzaria.models.dtos.BebidaPedidaDTO;
import com.apipizzaria.services.BebidaPedidaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/bebida_pedida")
@AllArgsConstructor
public class BebidaPedidaController {

 @Autowired
 private final BebidaPedidaService bebidaPedidaService;

    @GetMapping("/mostrar")
    public List<BebidaPedidaDTO> findAll() {
        return bebidaPedidaService.findAll();
    }

    @PostMapping("/salvar")
    public BebidaPedidaDTO save(@RequestBody BebidaPedidaDTO bebidaPedida){
    return bebidaPedidaService.save(bebidaPedida);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteById (@PathVariable Long id){
    bebidaPedidaService.deleteById(id);
    }

    @PutMapping("/atualizar/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody BebidaPedidaDTO bebidaPedida){
    bebidaPedidaService.update(id,bebidaPedida);

    }
}
