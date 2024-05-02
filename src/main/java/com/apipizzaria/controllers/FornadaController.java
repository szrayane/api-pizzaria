package com.apipizzaria.controllers;
import com.apipizzaria.models.FornadaModel;
import com.apipizzaria.models.dtos.FornadaDTO;
import com.apipizzaria.services.FornadaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/fornada")
public class FornadaController {

    private final FornadaService fornadaService;

   @GetMapping("/mostrar")
   public List<FornadaDTO> findAll(){
   return fornadaService.findAll();
   }

   @PostMapping("/salvar")
   public FornadaDTO save(@RequestBody FornadaDTO fornada) {
   return fornadaService.save(fornada);
   }

   @DeleteMapping("/deletar/{id}")
   public void delete (@PathVariable long id) {
   fornadaService.deleteById(id);
   }

   @PutMapping("/atualizar/{id}")
    public void update (@PathVariable long id, @RequestBody FornadaDTO fornada) {
    fornadaService.update(id, fornada);
   }


}
