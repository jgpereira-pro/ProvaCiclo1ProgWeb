package com.senac.joaog.dto.request;

import com.senac.joaog.entity.Role;

import java.util.List;

public record RecoveryUserDTO(

        Integer id,
        String usuarioLogin,
        List<Role> roles

) {
}
