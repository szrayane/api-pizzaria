package com.apipizzaria.services;
import com.apipizzaria.models.BebidaPedidaModel;
import com.apipizzaria.models.dtos.BebidaPedidaDTO;
import com.apipizzaria.repistories.BebidaPedidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BebidaPedidaService {

    private final BebidaPedidaRepository bebidaPedidaRepository;

    public List<BebidaPedidaDTO> findAll() {
        List<BebidaPedidaModel> bebidasPedidas = bebidaPedidaRepository.findAll();
        return bebidasPedidas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public BebidaPedidaDTO save(BebidaPedidaDTO bebidaPedida) {
        BebidaPedidaModel bebidaPedidaEntity = convertToEntity(bebidaPedida);
        BebidaPedidaModel savedBebidaPedida = bebidaPedidaRepository.save(bebidaPedidaEntity);
        return convertToDTO(savedBebidaPedida);
    }

    public void deleteById(Long id) {
        bebidaPedidaRepository.deleteById(id);
    }

    public void update(Long id, BebidaPedidaDTO bebidaPedidaAtualizada) {
        BebidaPedidaModel bebidaPedidaExistente = bebidaPedidaRepository.findById(id).orElseThrow(() -> new RuntimeException("Bebida não encontrada com o id: " + id));
        bebidaPedidaExistente.setQtd(bebidaPedidaAtualizada.getQtd());
        bebidaPedidaRepository.save(bebidaPedidaExistente);
    }

    private BebidaPedidaDTO convertToDTO(BebidaPedidaModel bebidaPedida) {
        BebidaPedidaDTO bebidaPedidaDTO = new BebidaPedidaDTO();
        bebidaPedidaDTO.setIdBebidaPedida(bebidaPedida.getIdBebidaPedida());
        bebidaPedidaDTO.setQtd(bebidaPedida.getQtd());
        return bebidaPedidaDTO;
    }

    private BebidaPedidaModel convertToEntity(BebidaPedidaDTO bebidaPedidaDTO) {
        BebidaPedidaModel bebidaPedida = new BebidaPedidaModel();
        bebidaPedida.setIdBebidaPedida(bebidaPedidaDTO.getIdBebidaPedida());
        bebidaPedida.setQtd(bebidaPedidaDTO.getQtd());
        return bebidaPedida;
    }
}


