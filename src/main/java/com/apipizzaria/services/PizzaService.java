package com.apipizzaria.services;
import com.apipizzaria.models.PizzaModel;
import com.apipizzaria.models.dtos.PizzaDTO;
import com.apipizzaria.repistories.PizzaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PizzaService {


    private final PizzaRepository pizzaRepository;

    public List<PizzaDTO> findAll() {
    List<PizzaModel> pizzaModel = pizzaRepository.findAll();
    return pizzaModel.stream().map(PizzaDTO::new).collect(Collectors.toList());
    }

    public PizzaDTO save(PizzaDTO pizzaDTO) {
    PizzaModel pizzaModel = new PizzaModel();
    pizzaModel.setIdPizza(pizzaDTO.getIdPizza());
    pizzaModel.setNome(pizzaDTO.getNome());
    pizzaModel.setPreco(pizzaDTO.getPreco());
    pizzaModel.setPersonalizada(pizzaDTO.isPersonalizada());
    PizzaDTO savedPizza = new PizzaDTO(pizzaModel);
    return savedPizza;
    }

    public void deleteById(long id) {
    pizzaRepository.deleteById(id);
    }

    public void update(long id, PizzaDTO pizzaAtualizada) {
    PizzaModel pizzaExistente = pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza não encontrada com o id: "+ id));
    pizzaExistente.setPersonalizada(pizzaAtualizada.isPersonalizada());
    pizzaExistente.setNome(pizzaAtualizada.getNome());
    pizzaExistente.setIdPizza(pizzaAtualizada.getIdPizza());
    pizzaExistente.setPreco(pizzaAtualizada.getPreco());
    pizzaRepository.save(pizzaExistente);
    }
}
