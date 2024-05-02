package com.apipizzaria.models.dtos;
import com.apipizzaria.models.PizzaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaDTO {

    private Long idPizza;

    private String nome;

    private float preco;

    private boolean personalizada;


    public PizzaDTO(PizzaModel pizzaModel) {
        this.idPizza = pizzaModel.getIdPizza();
        this.nome = pizzaModel.getNome();
        this.preco = pizzaModel.getPreco();
        this.personalizada = pizzaModel.isPersonalizada();
    }

    public static PizzaDTO fromPizzaModel(PizzaModel pizzaModel) {
        return new PizzaDTO(pizzaModel);
    }

    public PizzaModel toPizzaModel() {
        PizzaModel pizzaModel = new PizzaModel();
        pizzaModel.setIdPizza(this.getIdPizza());
        pizzaModel.setNome(this.getNome());
        pizzaModel.setPreco(this.getPreco());
        pizzaModel.setPersonalizada(this.isPersonalizada());
        return pizzaModel;
    }
}


