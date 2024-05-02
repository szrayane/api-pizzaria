package com.apipizzaria.services;
import com.apipizzaria.models.TamanhoModel;
import com.apipizzaria.models.dtos.TamanhoDTO;
import com.apipizzaria.repistories.TamanhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TamanhoService {

    @Autowired
    private final TamanhoRepository tamanhoRepository;

    public List<TamanhoDTO> findAll() {
        List<TamanhoModel> tamanhoModel = tamanhoRepository.findAll();
        return tamanhoModel.stream().map(TamanhoDTO::new).collect(Collectors.toList());
    }

    public TamanhoDTO save(TamanhoDTO tamanhoDTO) {
        TamanhoModel tamanhoModel = new TamanhoModel();
        tamanhoModel.setIdTamanho(tamanhoModel.getIdTamanho());
        tamanhoModel.setNome(tamanhoDTO.getNome());
        tamanhoModel.setDesconto(tamanhoDTO.getDesconto());
        TamanhoDTO savedTamanho= new TamanhoDTO(tamanhoModel);
        return savedTamanho;
    }

    public void deleteById(long id) {
    tamanhoRepository.deleteById(id);
    }

    public void update(long id, TamanhoDTO tamanhoAtualizado) {
        TamanhoModel tamanhoExistente = tamanhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Tamanho não encontrada com o id: "+ id));
        tamanhoExistente.setDesconto(tamanhoAtualizado.getDesconto());
        tamanhoExistente.setNome(tamanhoAtualizado.getNome());
        tamanhoExistente.setIdTamanho(tamanhoAtualizado.getIdTamanho());
        tamanhoRepository.save(tamanhoExistente);
    }

    public TamanhoDTO findById(Long id) {
        Optional<TamanhoModel> tamanhoOptional = tamanhoRepository.findById(id);
        if (tamanhoOptional.isPresent()) {
            return new TamanhoDTO(tamanhoOptional.get());
        } else {
            throw new RuntimeException("Tamanho não encontrado com o ID: " + id);
        }
    }

    public double calcularDescontoPorTamanho(String tamanhoPizza) {
        TamanhoModel tamanho = tamanhoRepository.findByNome(tamanhoPizza);
        if (tamanho == null) {
            throw new RuntimeException("Tamanho de pizza não encontrado: " + tamanhoPizza);
        }
        double desconto = tamanho.getDesconto();
        return desconto;
    }
}
