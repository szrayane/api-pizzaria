package com.apipizzaria.models.dtos;
import com.apipizzaria.models.TamanhoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TamanhoDTO {

        private Long idTamanho;

        private String nome;

        private float desconto;

        public TamanhoDTO (TamanhoModel tamanhoModel) {
        this.idTamanho = tamanhoModel.getIdTamanho();
        this.nome = tamanhoModel.getNome();
        this.desconto = tamanhoModel.getDesconto();
        }

        public static TamanhoDTO fromTamanhoDTO(TamanhoModel tamanhoModel){
        return new TamanhoDTO(tamanhoModel);
        }

        public TamanhoModel toTamanhoModel(){
        TamanhoModel tamanhoModel = new TamanhoModel();
        tamanhoModel.setIdTamanho(this.getIdTamanho());
        tamanhoModel.setNome(this.getNome());
        tamanhoModel.setDesconto(this.getDesconto());
        return tamanhoModel;
        }

    }


