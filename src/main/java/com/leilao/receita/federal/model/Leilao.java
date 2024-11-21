package com.leilao.receita.federal.model;

import com.leilao.receita.federal.enums.EstadoDoLeilao;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Leilao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "ID do leilão", example = "1")
    @Column(name = "leilao_id")
    private Long id;
    @Schema(description = "Nome do leilão", example = "Leilão de Eletrônicos")
    private String nome;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "leilao_entidade",
            joinColumns = @JoinColumn(name = "leilao_id"),
            inverseJoinColumns = @JoinColumn(name = "entidade_id")
    )
    private Set<EntidadeFinanceira> entidadesFinanceiras;

    @Schema(description = "Data de início do leilão", example = "2024-10-01T10:00:00Z")
    private Date dataInicio;
    @Schema(description = "Data de fim do leilão", example = "2024-10-10T18:00:00Z")
    private Date dataFim;
    @Schema(hidden = true)
    private EstadoDoLeilao estadoDoLeilao;
    @Embedded
    @Schema(description = "Local onde o leilão será realizado")
    private Local local;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public EstadoDoLeilao getEstadoDoLeilao() {
        return estadoDoLeilao;
    }

    public void setEstadoDoLeilao(EstadoDoLeilao estadoDoLeilao) {
        this.estadoDoLeilao = estadoDoLeilao;
    }

    public Set<EntidadeFinanceira> getEntidadesFinanceiras() {
        return entidadesFinanceiras;
    }

    public void setEntidadesFinanceiras(Set<EntidadeFinanceira> entidadesFinanceiras) {
        this.entidadesFinanceiras = entidadesFinanceiras;
    }
}


