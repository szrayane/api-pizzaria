package com.apipizzaria.models.dtos;
import com.apipizzaria.models.IngredienteModel;
import com.apipizzaria.models.PizzaIngredienteModel;
import com.apipizzaria.models.PizzaPedidaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PizzaIngredienteDTO {

        private PizzaPedidaModel pizzaPedida;

        private IngredienteModel ingrediente;


        public PizzaIngredienteDTO(PizzaIngredienteModel pizzaIngredienteModel){
        this.pizzaPedida = pizzaIngredienteModel.getPizzaPedida();
        this.ingrediente = pizzaIngredienteModel.getIngrediente();
        }

        public static PizzaIngredienteDTO fromPizzaIngredienteModel(PizzaIngredienteModel pizzaIngredienteModel){
        return new PizzaIngredienteDTO(pizzaIngredienteModel);
        }

        public PizzaIngredienteModel toPizzaIngredienteModel (){
        PizzaIngredienteModel pizzaIngredienteModel = new PizzaIngredienteModel();
        pizzaIngredienteModel.setPizzaPedida(this.getPizzaPedida());
        pizzaIngredienteModel.setIngrediente(this.getIngrediente());
        return pizzaIngredienteModel;
        }
    }

