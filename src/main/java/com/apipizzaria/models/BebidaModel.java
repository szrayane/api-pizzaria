package com.apipizzaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    @Table(name = "bebida")
    public class BebidaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_bebida")
        private Long idBebida;

        @Column(nullable = false, length = 50)
        private String nome;

        @Column(nullable = false, precision = 10, scale = 2)
        private BigDecimal preco;

    }


