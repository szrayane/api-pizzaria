package com.apipizzaria.services;
import com.apipizzaria.models.BebidaModel;
import com.apipizzaria.models.dtos.BebidaDTO;
import com.apipizzaria.repistories.BebidaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BebidaService {

    private final BebidaRepository bebidaRepository;

    public List<BebidaDTO> findAll() {
        List<BebidaModel> bebida = bebidaRepository.findAll();
        return bebida.stream().map(BebidaDTO::fromBebidaModel).collect(Collectors.toList());
    }

    public BebidaDTO save(BebidaDTO bebidaDTO) {
        BebidaModel bebidaModel = bebidaDTO.toBebidaModel();
        BebidaModel saveBebidaModel = bebidaRepository.save(bebidaModel);
        return BebidaDTO.fromBebidaModel(saveBebidaModel);
    }

    public void deleteById(Long id) {
        bebidaRepository.deleteById(id);
    }

    public BebidaDTO findById(Long id) {
        Optional<BebidaModel> bebidaOptional = bebidaRepository.findById(id);
        if (bebidaOptional.isPresent()) {
            return BebidaDTO.fromBebidaModel(bebidaOptional.get());
        } else {
            throw new RuntimeException("Bebida não encontrada com ID: " + id);
        }
    }

    public void update(Long id, BebidaDTO bebidaUpdated) {
        BebidaModel bibidaExistente = bebidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bebida não encontrada com id: " + id));
        bibidaExistente.setNome(bebidaUpdated.getNome());
        bibidaExistente.setPreco(bebidaUpdated.getPreco());
        bebidaRepository.save(bibidaExistente);
    }


    public BebidaModel toBebidaModel(BebidaDTO bebidaDTO) {
        if (bebidaDTO == null) {
            throw new IllegalArgumentException("Bebida não pode ser nulo");
        }

        BebidaModel bebidaModel = new BebidaModel();
        bebidaModel.setIdBebida(bebidaDTO.getIdBebida());
        bebidaModel.setNome(bebidaDTO.getNome());
        bebidaModel.setPreco(bebidaDTO.getPreco());

        return bebidaModel;
    }

}
