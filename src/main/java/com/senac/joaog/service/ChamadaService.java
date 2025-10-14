package com.senac.joaog.service;

import com.senac.joaog.dto.request.ChamadaDTORequest;
import com.senac.joaog.entity.Atendente;
import com.senac.joaog.entity.ChamadaAtendente;
import com.senac.joaog.repository.AtendenteRepository;
import com.senac.joaog.repository.ChamadaAtendenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChamadaService {

    private final ChamadaAtendenteRepository chamadaRepository;
    private final AtendenteRepository atendenteRepository;
    private final ModelMapper modelMapper;

    public ChamadaService(ChamadaAtendenteRepository chamadaRepository, AtendenteRepository atendenteRepository, ModelMapper modelMapper) {
        this.chamadaRepository = chamadaRepository;
        this.atendenteRepository = atendenteRepository;
        this.modelMapper = modelMapper;
    }

    public ChamadaAtendente registrarChamada(ChamadaDTORequest dto, int atendenteId) {
        Atendente atendente = atendenteRepository.findById(atendenteId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendente não encontrado!"));

        ChamadaAtendente chamada = modelMapper.map(dto, ChamadaAtendente.class);
        chamada.setAtendente(atendente);
        chamada.setDataAbertura(LocalDateTime.now());
        chamada.setStatus(1);

        // Salva a nova chamada no banco de dados
        return chamadaRepository.save(chamada);
    }

    /**
     * Lista todas as chamadas realizadas por um atendente específico.
     * @param atendenteId O ID do atendente.
     * @return Uma lista de chamadas.
     */
    public List<ChamadaAtendente> listarChamadasPorAtendenteId(Long atendenteId) {
        return chamadaRepository.findByAtendenteId(atendenteId);
    }
}