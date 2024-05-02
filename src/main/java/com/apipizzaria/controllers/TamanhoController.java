package com.apipizzaria.controllers;
import com.apipizzaria.models.dtos.TamanhoDTO;
import com.apipizzaria.services.TamanhoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tamanho")
public class TamanhoController {

    private final TamanhoService tamanhoService;

    @GetMapping("/mostrar")
    public List<TamanhoDTO> findAll() {
        return tamanhoService.findAll();
    }

    @PostMapping("/salvar")
    public TamanhoDTO save(@RequestBody TamanhoDTO tamanhoDTO) {
        return tamanhoService.save(tamanhoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete (@PathVariable long id){
        tamanhoService.deleteById(id);
    }

    @PutMapping("atualizar/{id}")
    public void update(@PathVariable long id, @RequestBody TamanhoDTO tamanhoDTO){
        tamanhoService.update(id, tamanhoDTO);
    }

}
