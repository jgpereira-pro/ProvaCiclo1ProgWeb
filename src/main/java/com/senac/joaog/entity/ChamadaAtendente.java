package com.senac.joaog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "chamada_atendente")
public class ChamadaAtendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chamada_atendente_id")
    private int id;

    @Column(name = "chamada_atendente_descricao")
    private String descricao;

    @Column(name = "chamada_atendente_data_abertura")
    private LocalDateTime dataAbertura;

    @Column(name = "chamada_atendente_data_fechamento")
    private LocalDateTime dataFechamento;

    @Column(name = "chamada_atendente_status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "chamada_atendente_id", nullable = false)
    @JsonIgnore
    private ChamadaAtendente chamadaAtendente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ChamadaAtendente getChamadaAtendente() {
        return chamadaAtendente;
    }

    public void setChamadaAtendente(ChamadaAtendente chamadaAtendente) {
        this.chamadaAtendente = chamadaAtendente;
    }
}
