package com.leilao.receita.federal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Schema(description = "Nome do Usuário", example = "Patrick Gabriel de Souza")
    private String nome;

}
