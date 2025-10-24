//package com.senac.joaog.service;
//
//import com.senac.joaog.dto.request.ChamadaDTORequest;
//import com.senac.joaog.entity.Atendente;
//import com.senac.joaog.entity.ChamadaAtendente;
//import com.senac.joaog.repository.AtendenteRepository;
//import com.senac.joaog.repository.ChamadaAtendenteRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class ChamadaAtendenteService {
//
//    private final ChamadaAtendenteRepository chamadaAtendenteRepository;
//    private final AtendenteRepository atendenteRepository;
//    private final ModelMapper modelMapper;
//
//    public ChamadaAtendenteService(ChamadaAtendenteRepository chamadaRepository, AtendenteRepository atendenteRepository, ModelMapper modelMapper) {
//        this.chamadaAtendenteRepository = chamadaRepository;
//        this.atendenteRepository = atendenteRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    public ChamadaAtendente registrarChamada(ChamadaDTORequest dto, int atendenteId) {
//        Atendente atendente = atendenteRepository.findById(atendenteId)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendente não encontrado!"));
//
//        ChamadaAtendente chamada = modelMapper.map(dto, ChamadaAtendente.class);
//        chamada.setAtendente(atendente);
//        chamada.setDataAbertura(LocalDateTime.now());
//        chamada.setStatus(1);
//
//        return chamadaAtendenteRepository.save(chamada);
//    }
//
//    public List<ChamadaAtendente> listarChamadasPorAtendenteId(int atendenteId) {
//        return chamadaAtendenteRepository.findByAtendenteId(atendenteId);
//    }
//}