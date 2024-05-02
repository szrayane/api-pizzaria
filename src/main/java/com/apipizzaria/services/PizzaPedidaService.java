package com.apipizzaria.services;
import com.apipizzaria.models.BebidaModel;
import com.apipizzaria.models.ClienteModel;
import com.apipizzaria.models.PizzaPedidaModel;
import com.apipizzaria.models.TamanhoModel;
import com.apipizzaria.models.dtos.BebidaDTO;
import com.apipizzaria.models.dtos.ClienteDTO;
import com.apipizzaria.models.dtos.PizzaPedidaDTO;
import com.apipizzaria.repistories.PizzaPedidaRepository;
import com.apipizzaria.repistories.TamanhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PizzaPedidaService {

    private final PizzaPedidaRepository pizzaPedidaRepository;
    private final TamanhoRepository tamanhoRepository;
    private final BebidaService bebidaService;
    private final TamanhoService tamanhoService;
    private final ClienteService clienteService;

    public List<PizzaPedidaDTO> findAll() {
        List<PizzaPedidaModel> pizzaPedidaModel = pizzaPedidaRepository.findAll();
        return pizzaPedidaModel.stream().map(PizzaPedidaDTO::new).collect(Collectors.toList());
    }

    public PizzaPedidaDTO save(PizzaPedidaDTO pizzaPedidaDTO, UUID clienteId) {
        PizzaPedidaModel pizzaPedidaModel = new PizzaPedidaModel();
        pizzaPedidaModel.setQuantidade(pizzaPedidaDTO.getQuantidade());
        pizzaPedidaModel.setIdPizzaPedida(pizzaPedidaDTO.getIdPizzaPedida());
        pizzaPedidaModel.setPedido(pizzaPedidaDTO.getPedido());
        pizzaPedidaModel.setPizza(pizzaPedidaDTO.getPizza());
        ClienteDTO clienteDTO = clienteService.findById(clienteId);
        ClienteModel clienteModel = clienteDTO.toClienteModel();
        pizzaPedidaModel.setCliente(clienteModel);
        TamanhoModel tamanho = new TamanhoModel();
        tamanho.setNome(pizzaPedidaDTO.getTamanho().getNome());
        tamanho.setDesconto(pizzaPedidaDTO.getTamanho().getDesconto());
        tamanho = tamanhoRepository.save(tamanho);
        pizzaPedidaModel.setTamanho(tamanho);
        PizzaPedidaModel savedPizzaPedidaModel = pizzaPedidaRepository.save(pizzaPedidaModel);
        return new PizzaPedidaDTO(savedPizzaPedidaModel);
    }


    public void delete(long id) {
        pizzaPedidaRepository.deleteById(id);
    }

    public void update(long id, PizzaPedidaDTO pizzaPedidaAtualizada) {
        PizzaPedidaModel pizzaExistente = pizzaPedidaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pizza pedida não encontrada com o id: " + id));
        pizzaExistente.setPizza(pizzaPedidaAtualizada.getPizza());
        pizzaExistente.setQuantidade(pizzaPedidaAtualizada.getQuantidade());
        pizzaExistente.setPedido(pizzaPedidaAtualizada.getPedido());
        pizzaExistente.setIdPizzaPedida(pizzaPedidaAtualizada.getIdPizzaPedida());
        pizzaExistente.setTamanho(pizzaPedidaAtualizada.getTamanho());
        pizzaPedidaRepository.save(pizzaExistente);
    }

    public String getTamanhoPizzaPedida(Long idPizzaPedida) {
        PizzaPedidaModel pizzaPedidaModel = pizzaPedidaRepository.findById(idPizzaPedida)
                .orElseThrow(() -> new RuntimeException("Pizza pedida não encontrada com o id: " + idPizzaPedida));
        return tamanhoService.findById(pizzaPedidaModel.getTamanho().getIdTamanho()).getNome();
    }
}
