package com.apipizzaria.services;
import com.apipizzaria.models.IngredienteModel;
import com.apipizzaria.models.PedidoModel;
import com.apipizzaria.models.dtos.PedidoDTO;
import com.apipizzaria.repistories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apipizzaria.models.dtos.IngredienteDTO;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public PedidoDTO update(UUID id, PedidoDTO pedidoDTO) {
        Optional<PedidoModel> pedidoOptional = pedidoRepository.findById(id);
        if (pedidoOptional.isPresent()) {
            PedidoModel pedidoExistente = pedidoOptional.get();
            pedidoExistente.setCliente(pedidoDTO.getCliente());
            pedidoExistente.setFornada(pedidoDTO.getFornada());
            pedidoExistente.setHoraPedido(pedidoDTO.getHoraPedido());
            List<IngredienteModel> ingredientesList = pedidoDTO.getIngredientes().stream()
                    .map(IngredienteDTO::toIngredienteModel)
                    .collect(Collectors.toList());
            pedidoExistente.setIngredientes(new ArrayList<>(ingredientesList));
            PedidoModel pedidoAtualizado = pedidoRepository.save(pedidoExistente);
            return convertToDTO(pedidoAtualizado);
        } else {
            throw new RuntimeException("Pedido não encontrado com o ID: " + id);
        }
    }

    public List<PedidoDTO> findAll() {
        List<PedidoModel> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PedidoDTO save(PedidoDTO pedidoDTO) {
        PedidoModel pedidoModel = convertToModel(pedidoDTO);
        List<IngredienteModel> ingredientesList = pedidoDTO.getIngredientes().stream()
                .map(IngredienteDTO::toIngredienteModel)
                .collect(Collectors.toList());
        pedidoModel.setIngredientes(ingredientesList);
        PedidoModel savedPedido = pedidoRepository.save(pedidoModel);
        return convertToDTO(savedPedido);
    }

    public void deleteById(UUID id) {
        pedidoRepository.deleteById(id);
    }

    private PedidoDTO convertToDTO(PedidoModel pedidoModel) {
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setIdPedido(pedidoModel.getIdPedido());
        pedidoDTO.setCliente(pedidoModel.getCliente());
        pedidoDTO.setFornada(pedidoModel.getFornada());
        pedidoDTO.setHoraPedido(pedidoModel.getHoraPedido());
        pedidoDTO.setIngredientes(pedidoModel.getIngredientes().stream()
                .map(IngredienteModel::toIngredienteDTO)
                .collect(Collectors.toList()));
        return pedidoDTO;
    }

    private PedidoModel convertToModel(PedidoDTO pedidoDTO) {
        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setIdPedido(pedidoDTO.getIdPedido());
        pedidoModel.setCliente(pedidoDTO.getCliente());
        pedidoModel.setFornada(pedidoDTO.getFornada());
        pedidoModel.setHoraPedido(pedidoDTO.getHoraPedido());
        return pedidoModel;
    }
}
