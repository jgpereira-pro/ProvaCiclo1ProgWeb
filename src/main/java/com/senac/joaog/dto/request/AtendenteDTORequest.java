package com.senac.joaog.dto.request;

import jakarta.validation.constraints.NotBlank;

public class AtendenteDTORequest {

    @NotBlank(message= "o nome é obrigatório")
    private String nome;

    private String usuario_login;

    private String chave_acesso;

    private String roleName;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
