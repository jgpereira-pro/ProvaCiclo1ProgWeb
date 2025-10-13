package com.senac.joaog.repository;

import com.senac.joaog.entity.Atendente;
import com.senac.joaog.entity.Role;
import com.senac.joaog.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
