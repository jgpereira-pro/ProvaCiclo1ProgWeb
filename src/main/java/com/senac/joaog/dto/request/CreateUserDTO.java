package com.senac.joaog.dto.request;

import com.senac.joaog.entity.RoleName;

import java.time.LocalDateTime;

public record CreateUserDTO(

        String nome,
        String usuarioLogin,
        String chaveAcesso,
        LocalDateTime dataCricacao,
        RoleName role

) {
}
