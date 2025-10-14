package com.senac.joaog.repository;

import com.senac.joaog.entity.ChamadaAtendente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadaAtendenteRepository extends JpaRepository<ChamadaAtendente, Integer> {
    List<ChamadaAtendente> findByAtendenteId(int atendenteId);
}
