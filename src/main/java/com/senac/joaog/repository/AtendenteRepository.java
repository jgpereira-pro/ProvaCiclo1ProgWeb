package com.senac.joaog.repository;

import com.senac.joaog.entity.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {

    Optional<Atendente> findByUsuarioLogin(String subject);
}
