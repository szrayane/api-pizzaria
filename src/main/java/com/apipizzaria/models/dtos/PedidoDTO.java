package com.apipizzaria.models.dtos;
import com.apipizzaria.models.ClienteModel;
import com.apipizzaria.models.FornadaModel;
import com.apipizzaria.models.PedidoModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {


    private List<IngredienteDTO> ingredientes;
    private UUID idPedido;
    private UUID idCliente;
    private FornadaModel fornada;
    private Timestamp horaPedido;
    private ClienteModel cliente;

    public PedidoDTO(PedidoModel pedidoModel) {
        this.idPedido = pedidoModel.getIdPedido();
        this.idCliente = pedidoModel.getCliente().getId();
        this.fornada = pedidoModel.getFornada();
        this.horaPedido = pedidoModel.getHoraPedido();
    }

    public static PedidoDTO fromPedidoDTO(PedidoModel pedidoModel) {
        return new PedidoDTO(pedidoModel);
    }

    public PedidoModel toPedidoModel() {
        PedidoModel pedidoModel = new PedidoModel();
        pedidoModel.setIdPedido(this.getIdPedido());
        pedidoModel.setCliente(this.getCliente());
        pedidoModel.setFornada(this.getFornada());
        pedidoModel.setHoraPedido(this.getHoraPedido());
        return pedidoModel;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }


}
