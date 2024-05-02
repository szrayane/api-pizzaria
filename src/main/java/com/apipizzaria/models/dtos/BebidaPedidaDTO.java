package com.apipizzaria.models.dtos;
import com.apipizzaria.models.BebidaPedidaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BebidaPedidaDTO {

    private Long idBebidaPedida;
    private UUID pedidoId;
    private int qtd;

    public BebidaPedidaDTO(BebidaPedidaModel bebidaPedidaModel) {
        this.idBebidaPedida = bebidaPedidaModel.getIdBebidaPedida();
        this.pedidoId = bebidaPedidaModel.getPedido() != null ? bebidaPedidaModel.getPedido().getIdPedido() : null;
        this.qtd = bebidaPedidaModel.getQtd();
    }


}




