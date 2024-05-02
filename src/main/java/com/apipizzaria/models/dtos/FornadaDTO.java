package com.apipizzaria.models.dtos;
import com.apipizzaria.models.FornadaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FornadaDTO {

        private Long idFornada;

        private int numFornada;

        private int qtdPizzas;

        public FornadaDTO(FornadaModel fornadaModel){
            this.idFornada = fornadaModel.getIdFornada();
            this.numFornada = fornadaModel.getNumFornada();
            this.qtdPizzas = fornadaModel.getQtdPizzas();
        }

        public static FornadaDTO fromFornadaModel(FornadaModel fornadaModel) {
         return new FornadaDTO(fornadaModel);
        }

        public FornadaModel toFornadaModel(){
        FornadaModel fornadaModel = new FornadaModel();
        fornadaModel.setIdFornada(this.getIdFornada());
        fornadaModel.setNumFornada(this.getNumFornada());
        fornadaModel.setQtdPizzas(this.getQtdPizzas());
        return fornadaModel;
        }
    }


