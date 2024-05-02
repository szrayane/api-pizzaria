package com.apipizzaria.models;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaIngredienteId implements Serializable {

    @Column(name = "id_pizza_pedida")
    private Long idPizzaPedida;

    @Column(name = "id_ingrediente")
    private Long idIngrediente;


}
