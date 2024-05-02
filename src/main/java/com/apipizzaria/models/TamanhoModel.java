package com.apipizzaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tamanho")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TamanhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTamanho;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(name = "desconto", nullable = false)
    private float desconto;
}
