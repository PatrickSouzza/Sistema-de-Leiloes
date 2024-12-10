package com.leilao.receita.federal.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto", discriminatorType = DiscriminatorType.STRING)
public abstract class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeProduto;

    //

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
