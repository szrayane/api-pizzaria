package com.apipizzaria.services;
import com.apipizzaria.models.ClienteModel;
import com.apipizzaria.models.dtos.ClienteDTO;
import com.apipizzaria.repistories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<ClienteDTO> findAll() {
        List<ClienteModel> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO save(ClienteDTO clienteDTO) {
        ClienteModel clienteModel = clienteDTO.toClienteModel();
        if (clienteDTO.getSenha() == null || clienteDTO.getSenha().isEmpty()) {
            if (clienteModel.getSenha() == null || clienteModel.getSenha().isEmpty()) {
                String senhaPadrao = "senhaPadrao123";
                clienteModel.setSenha(senhaPadrao);
            }
        } else {
            clienteModel.setSenha(clienteDTO.getSenha());
        }

        try {
            ClienteModel savedCliente = clienteRepository.save(clienteModel);
            return new ClienteDTO(savedCliente);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao salvar cliente: " + e.getMessage());
        }
    }


    public void delete(UUID id) {
        try {
            clienteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new RuntimeException("Cliente não encontrado com o id: " + id);
        }
    }

    public ClienteDTO update(UUID id, ClienteDTO clienteAtualizado) {
        ClienteModel clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o id: " + id));

        clienteExistente.setNome(clienteAtualizado.getNome());
        clienteExistente.setTelefone(clienteAtualizado.getTelefone());
        clienteExistente.setEndereco(clienteAtualizado.getEndereco());
        clienteExistente.setLogin(clienteAtualizado.getLogin());
        ClienteModel savedCliente = clienteRepository.save(clienteExistente);
        return new ClienteDTO(savedCliente);
    }

    public ClienteDTO findById(UUID id) {
        Optional<ClienteModel> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            return new ClienteDTO(clienteOptional.get());
        } else {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
    }

    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) {
        ClienteModel cliente = clienteDTO.toClienteModel();
        ClienteModel clienteSalvo = clienteRepository.save(cliente);
        return new ClienteDTO(clienteSalvo);
    }

    public boolean atualizarSenha(UUID id, String novaSenha) {
        Optional<ClienteModel> optionalCliente = clienteRepository.findById(id);
        if (optionalCliente.isPresent()) {
            ClienteModel cliente = optionalCliente.get();
            cliente.setSenha(novaSenha);
            clienteRepository.save(cliente);
            return true;
        } else {
            return false;
        }
    }
}
