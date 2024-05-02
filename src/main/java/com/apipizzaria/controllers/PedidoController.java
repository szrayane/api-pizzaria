package com.apipizzaria.controllers;
import com.apipizzaria.models.dtos.PedidoDTO;
import com.apipizzaria.services.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/mostrar")
    public List<PedidoDTO> findAll() {
        return pedidoService.findAll();
    }

    @PostMapping("/salvar")
    public PedidoDTO save(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.save(pedidoDTO);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable UUID id) {
        pedidoService.deleteById(id);
    }

    @PutMapping("/atualizar/{id}")
    public PedidoDTO update(@PathVariable UUID id, @RequestBody PedidoDTO pedido) {
        return pedidoService.update(id, pedido);
    }
}