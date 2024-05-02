package com.apipizzaria.models.dtos;
import com.apipizzaria.models.IngredienteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteDTO {

    private Long idIngrediente;
    private String nome;
    private float preco;

    public IngredienteDTO(IngredienteModel ingredienteModel) {
        this.idIngrediente = ingredienteModel.getIdIngrediente();
        this.nome = ingredienteModel.getNome();
        this.preco = ingredienteModel.getPreco();
    }

    public static IngredienteModel toIngredienteModel(IngredienteDTO ingredienteDTO) {
        IngredienteModel ingredienteModel = new IngredienteModel();
        ingredienteModel.setIdIngrediente(ingredienteDTO.getIdIngrediente());
        ingredienteModel.setNome(ingredienteDTO.getNome());
        ingredienteModel.setPreco(ingredienteDTO.getPreco());
        return ingredienteModel;
    }

}
