package com.senac.joaog.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "atendente")
public class Atendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atendente_id")
    private Integer id;

    @Column(name = "atendente_nome", length = 200)
    private String nome;

    @Column(name = "atendente_usuario_login", length = 100, unique = true, nullable = false)
    private String usuarioLogin;

    @Column(name = "atendente_chave_acesso", length = 255, nullable = false)
    private String chaveAcesso;

    @Column(name = "atendente_data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "atendente_ativo")
    private int ativo;

    @OneToMany(mappedBy = "atendente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<ChamadaAtendente> chamadas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "atendente_roles",
            joinColumns = @JoinColumn(name = "atendente_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getChaveAcesso() {
        return chaveAcesso;
    }

    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public List<ChamadaAtendente> getChamadas() {
        return chamadas;
    }

    public void setChamadas(List<ChamadaAtendente> chamadas) {
        this.chamadas = chamadas;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}