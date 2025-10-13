package com.senac.joaog.dto.request;

import com.senac.joaog.entity.Role;

import java.util.List;

public record RecoveryUserDTO(

        Long id,
        String usuario_login,
        List<Role> roles

) {
}
