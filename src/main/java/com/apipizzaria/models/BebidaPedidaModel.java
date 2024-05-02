package com.apipizzaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bebida_pedida")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BebidaPedidaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBebidaPedida;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoModel pedido;

    @Column(nullable = false)
    private int qtd;

}
