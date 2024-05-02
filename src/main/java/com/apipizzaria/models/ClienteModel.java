package com.apipizzaria.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id; // Corrigido para UUID

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String telefone;

    @Column(nullable = false, length = 200)
    private String endereco;

    @Column(nullable = false, length = 30)
    private String login;

    private String senha;
}