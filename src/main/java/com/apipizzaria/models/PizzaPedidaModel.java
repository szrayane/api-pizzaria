package com.apipizzaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizza-pedida")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaPedidaModel {

    @ManyToOne
    @JoinColumn(name = "id_bebida")
    private BebidaModel bebida;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizzaPedida;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoModel pedido;

    @ManyToOne
    @JoinColumn(name = "id_pizza")
    private PizzaModel pizza;

    @ManyToOne
    @JoinColumn(name = "id_tamanho")
    private TamanhoModel tamanho;

    @Column(nullable = false)
    private int quantidade;


    public void setCliente(ClienteModel clienteModel) {

    }
}
