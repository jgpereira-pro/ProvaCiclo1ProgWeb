package com.senac.joaog.repository;

import com.senac.joaog.entity.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AtendenteRepository extends JpaRepository<Atendente, Integer> {

    @Query("SELECT a FROM Atendente a WHERE a.status >=0")
    List<Atendente> listarAtendentesAtivos();

    @Query("SELECT a FROM Atendente a WHERE a.id = :id AND a.status >=0")
    Atendente obterAlunoAtivoPorId(@Param("id") int id);

    Optional<Atendente> findByUsuario_login(String usuario_login);
}
