package com.senac.joaog.dto.request;

import com.senac.joaog.entity.RoleName;

public record LoginUserDTO(

        String email,
        String password,
        RoleName role

) {
}
