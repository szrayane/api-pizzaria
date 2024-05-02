package com.apipizzaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPedido;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "id_fornada")
    private FornadaModel fornada;

    @Column(nullable = false)
    private Timestamp horaPedido;

    @ManyToMany
    @JoinTable(
            name = "pedido_ingrediente",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediente_id")
    )
    private List<IngredienteModel> ingredientes;

}

