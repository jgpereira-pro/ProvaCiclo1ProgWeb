package com.senac.joaog.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ChamadaDTORequest {
    @NotBlank(message = "A descrição da chamada é obrigatória.")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
