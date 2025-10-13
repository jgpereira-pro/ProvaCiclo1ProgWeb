package com.senac.joaog.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Role;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Atendente")
public class Atendente {

    @Id
    @GeneratedValue
    @Column(name ="atendente_id")
    private Integer id;

    @Column(name = "atendente_nome")
    private String nome;

    @Column(name = "atendente_usuario_login")
    private String usuario_login;

    @Column(name = "atendente_chave_acesso")
    private String chave_acesso;

    @Column(name = "atendente_data_criacao")
    private LocalDate data_criacao;

    @Column(name = "atendente_ativo")
    private Integer ativo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(name="atendente_role",
            joinColumns = @JoinColumn(name = "atendente_id"),
            inverseJoinColumns = @JoinColumn(name="role_id"))
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

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

    public String getUsuario_login() {
        return usuario_login;
    }

    public void setUsuario_login(String usuario_login) {
        this.usuario_login = usuario_login;
    }

    public String getChave_acesso() {
        return chave_acesso;
    }

    public void setChave_acesso(String chave_acesso) {
        this.chave_acesso = chave_acesso;
    }

    public LocalDate getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(LocalDate data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }
}
