package com.apipizzaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizza_pedida_ingrediente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaIngredienteModel {

    @EmbeddedId
    private PizzaIngredienteId id;

    @ManyToOne
    @MapsId("idPizzaPedida")
    @JoinColumn(name = "id_pizza_pedida")
    private PizzaPedidaModel pizzaPedida;

    @ManyToOne
    @MapsId("idIngrediente")
    @JoinColumn(name = "id_ingrediente")
    private IngredienteModel ingrediente;

    // Constructors, getters, and setters
}
