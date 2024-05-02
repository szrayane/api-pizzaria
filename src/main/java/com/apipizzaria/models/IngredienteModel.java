package com.apipizzaria.models;
import com.apipizzaria.models.dtos.IngredienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingrediente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIngrediente;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private float preco;

    public static IngredienteModel fromIngredienteDTO(IngredienteDTO ingredienteDTO) {
        IngredienteModel ingredienteModel = new IngredienteModel();
        ingredienteModel.setIdIngrediente(ingredienteDTO.getIdIngrediente());
        ingredienteModel.setNome(ingredienteDTO.getNome());
        ingredienteModel.setPreco(ingredienteDTO.getPreco());
        return ingredienteModel;
    }
    public IngredienteDTO toIngredienteDTO() {
        return new IngredienteDTO(this);
    }
}





