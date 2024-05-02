package com.apipizzaria.services;
import com.apipizzaria.models.FornadaModel;
import com.apipizzaria.models.dtos.FornadaDTO;
import com.apipizzaria.repistories.FornadaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FornadaService {

    private final FornadaRepository fornadaRepository;

    public List<FornadaDTO> findAll() {
    List<FornadaModel> fornada = fornadaRepository.findAll();
    return fornada.stream().map(FornadaDTO::new).collect(Collectors.toList());

    }

    public FornadaDTO save(FornadaDTO fornadaDTO) {
    FornadaModel fornadaModel = new FornadaModel();
    fornadaModel.setQtdPizzas(fornadaDTO.getQtdPizzas());
    fornadaModel.setIdFornada(fornadaDTO.getIdFornada());
    fornadaModel.setNumFornada(fornadaDTO.getNumFornada());
    FornadaDTO savedFornadaDTO = new FornadaDTO(fornadaModel);
    return savedFornadaDTO;
    }

    public void deleteById(long id) {
    fornadaRepository.deleteById(id);
    }

    public void update(long id, FornadaDTO fornadaAtualizada) {
    FornadaModel fornadaExistente = fornadaRepository.findById(id).orElseThrow(() -> new RuntimeException("Fornada não encontrado com o id: " + id));
    fornadaExistente.setIdFornada(fornadaAtualizada.getIdFornada());
    fornadaExistente.setNumFornada(fornadaAtualizada.getNumFornada());
    fornadaExistente.setQtdPizzas(fornadaAtualizada.getQtdPizzas());
    fornadaRepository.save(fornadaExistente);
    }
}
