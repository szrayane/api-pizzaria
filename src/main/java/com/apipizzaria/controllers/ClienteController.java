package com.apipizzaria.controllers;
import com.apipizzaria.models.dtos.ClienteDTO;
import com.apipizzaria.services.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/mostrar")
    public List<ClienteDTO> findAll(){
        return clienteService.findAll();
    }

    @PostMapping("/salvar")
    public ClienteDTO save(@RequestBody ClienteDTO cliente){
        return clienteService.save(cliente);
    }

    @DeleteMapping("/deletar/{id}")
    public void delete (@PathVariable UUID id){
        clienteService.delete(id);
    }

    @PutMapping("/atualizar/{id}")
    public void update(@PathVariable UUID id, @RequestBody ClienteDTO cliente){
        clienteService.update(id, cliente);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO novoCliente = clienteService.registrarCliente(clienteDTO);
        return ResponseEntity.ok("Cliente registrado com sucesso. ID: " + novoCliente.getIdCliente());
    }

    @PutMapping("/senha/{id}")
    public ResponseEntity<String> atualizarSenha(@PathVariable UUID id, @RequestParam String novaSenha) {
        if (clienteService.atualizarSenha(id, novaSenha)) {
            return ResponseEntity.ok("Senha atualizada com sucesso.");
        } else {
            return ResponseEntity.badRequest().body("Falha ao atualizar senha. Cliente não encontrado.");
        }
    }
}