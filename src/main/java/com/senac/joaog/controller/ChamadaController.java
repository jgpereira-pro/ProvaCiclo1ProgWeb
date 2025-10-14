package com.senac.joaog.controller;

import com.senac.joaog.dto.request.ChamadaDTORequest;
import com.senac.joaog.entity.ChamadaAtendente;
import com.senac.joaog.service.ChamadaService;
import com.senac.joaog.service.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/chamada_atendente")
public class ChamadaController {

    private final ChamadaService chamadaService;

    public ChamadaController(ChamadaService chamadaService) {
        this.chamadaService = chamadaService;
    }

    @PostMapping
    public ResponseEntity<ChamadaAtendente> registrarChamada(
            @Valid @RequestBody ChamadaDTORequest dto,
            Authentication authentication
    ) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        ChamadaAtendente novaChamada = chamadaService.registrarChamada(dto, userDetails.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(novaChamada);
    }

    @GetMapping("/listaa chamadas")
    public ResponseEntity<List<ChamadaAtendente>> listarMinhasChamadas(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<ChamadaAtendente> chamadas = chamadaService.listarChamadasPorAtendenteId(userDetails.getId());
        return ResponseEntity.ok(chamadas);
    }
}