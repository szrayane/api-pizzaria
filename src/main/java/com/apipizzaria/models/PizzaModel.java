package com.apipizzaria.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pizza")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PizzaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizza;

    @Column(length = 50)
    private String nome;

    @Column(nullable = false)
    private float preco;

    @Column(nullable = false)
    private boolean personalizada;


    @ManyToMany
    private Set<IngredienteModel> ingredientes = new HashSet<>();
}


