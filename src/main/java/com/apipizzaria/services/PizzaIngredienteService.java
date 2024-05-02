package com.apipizzaria.services;;
import com.apipizzaria.models.PizzaIngredienteModel;
import com.apipizzaria.models.dtos.IngredienteDTO;
import com.apipizzaria.models.dtos.PizzaIngredienteDTO;
import com.apipizzaria.repistories.PizzaIngredienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PizzaIngredienteService {

    private final PizzaIngredienteRepository pizzaIngredienteRepository;


    public List<PizzaIngredienteDTO> findAll() {
        List<PizzaIngredienteModel> pizzaIngrediente = pizzaIngredienteRepository.findAll();
        return pizzaIngrediente.stream().map(PizzaIngredienteDTO::new).collect(Collectors.toList());
    }

    public PizzaIngredienteDTO save(PizzaIngredienteDTO pizzaIngredienteDTO) {
        PizzaIngredienteModel pizzaIngredienteModel = new PizzaIngredienteModel();
        pizzaIngredienteModel.setPizzaPedida(pizzaIngredienteDTO.getPizzaPedida());
        pizzaIngredienteModel.setIngrediente(pizzaIngredienteDTO.getIngrediente());
        PizzaIngredienteDTO savedPizzaIngredienteDTO = new PizzaIngredienteDTO(pizzaIngredienteModel);
        return savedPizzaIngredienteDTO;
    }


    public void deleteById(long id) {
     pizzaIngredienteRepository.deleteById(id);
    }

    public void update(long id, PizzaIngredienteDTO pizzaIngredienteAtualizada) {
        PizzaIngredienteModel ingredienteExistente = pizzaIngredienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado com o id: " + id));
        ingredienteExistente.setIngrediente(pizzaIngredienteAtualizada.getIngrediente());
        ingredienteExistente.setPizzaPedida(pizzaIngredienteAtualizada.getPizzaPedida());
        pizzaIngredienteRepository.save(ingredienteExistente);
    }
}
