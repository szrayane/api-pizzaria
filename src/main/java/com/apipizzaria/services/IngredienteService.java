package com.apipizzaria.services;
import com.apipizzaria.models.IngredienteModel;
import com.apipizzaria.models.dtos.IngredienteDTO;
import com.apipizzaria.repistories.IngredienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IngredienteService {

    private final IngredienteRepository ingredienteRepository;


    public List<IngredienteDTO> findAll() {
    List<IngredienteModel> ingredienteModel = ingredienteRepository.findAll();
    return ingredienteModel.stream().map(IngredienteDTO::new).collect(Collectors.toList());
    }

    public IngredienteDTO save(IngredienteDTO ingredienteDTO) {
    IngredienteModel ingredienteModel = new IngredienteModel();
    ingredienteModel.setIdIngrediente(ingredienteDTO.getIdIngrediente());
    ingredienteModel.setNome(ingredienteDTO.getNome());
    ingredienteModel.setPreco(ingredienteDTO.getPreco());
    IngredienteDTO savedIngrediente = new IngredienteDTO(ingredienteModel);
    return savedIngrediente;
    }

    public void deleteById(long id) {
    ingredienteRepository.deleteById(id);
    }

    public void update(long id, IngredienteDTO ingredienteAtualizado) {
      IngredienteModel ingredienteExistente = ingredienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingrediente não encontrado com o id: " + id));
      ingredienteExistente.setPreco(ingredienteAtualizado.getPreco());
      ingredienteExistente.setNome(ingredienteAtualizado.getNome());
      ingredienteExistente.setIdIngrediente(ingredienteAtualizado.getIdIngrediente());
      ingredienteRepository.save(ingredienteExistente);
    }
}
