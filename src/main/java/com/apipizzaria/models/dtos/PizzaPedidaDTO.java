package com.apipizzaria.models.dtos;
import com.apipizzaria.models.PedidoModel;
import com.apipizzaria.models.PizzaModel;
import com.apipizzaria.models.PizzaPedidaModel;
import com.apipizzaria.models.TamanhoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaPedidaDTO {

        private BebidaDTO bebida;

        private Long idPizzaPedida;

        private PedidoModel pedido;

        private PizzaModel pizza;

        private TamanhoModel tamanho;

        private int quantidade;

        public PizzaPedidaDTO(PizzaPedidaModel pizzaPedidaModel){
        this.idPizzaPedida = pizzaPedidaModel.getIdPizzaPedida();
        this.pedido= pizzaPedidaModel.getPedido();
        this.pizza = pizzaPedidaModel.getPizza();
        this.tamanho = pizzaPedidaModel.getTamanho();
        this.quantidade = pizzaPedidaModel.getQuantidade();
        }

        public static PizzaPedidaDTO fromPizzaPedidaModel(PizzaPedidaModel pizzaPedidaModel){
        return new PizzaPedidaDTO(pizzaPedidaModel);
        }

        public PizzaPedidaModel toPizzaPedidaModel (){
        PizzaPedidaModel pizzaPedidaModel = new PizzaPedidaModel();
        pizzaPedidaModel.setIdPizzaPedida(this.getIdPizzaPedida());
        pizzaPedidaModel.setPedido(this.getPedido());
        pizzaPedidaModel.setPizza(this.getPizza());
        pizzaPedidaModel.setTamanho(this.getTamanho());
        pizzaPedidaModel.setQuantidade(this.getQuantidade());
        return pizzaPedidaModel;
        }
}
