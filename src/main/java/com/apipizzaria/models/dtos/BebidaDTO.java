package com.apipizzaria.models.dtos;
import com.apipizzaria.models.BebidaModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BebidaDTO {

    private Long idBebida;
    private String nome;
    private BigDecimal preco;

    public BebidaDTO(BebidaModel bebidaModel) {
        this.idBebida = bebidaModel.getIdBebida();
        this.nome = bebidaModel.getNome();
        this.preco = bebidaModel.getPreco();
    }

    public static BebidaDTO fromBebidaModel(BebidaModel bebidaModel) {
        return new BebidaDTO(bebidaModel);
    }


    public BebidaModel toBebidaModel() {
        BebidaModel bebidaModel = new BebidaModel();
        bebidaModel.setIdBebida(this.idBebida);
        bebidaModel.setNome(this.nome);
        bebidaModel.setPreco(this.preco);
        return bebidaModel;
    }

}