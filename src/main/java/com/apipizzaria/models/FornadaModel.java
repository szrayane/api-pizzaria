package com.apipizzaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fornada")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FornadaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFornada;

    @Column(nullable = false)
    private int numFornada;
    @Column(nullable = false)
    private int qtdPizzas;

}
