package com.senac.joaog.service;

import com.senac.joaog.dto.request.AtendenteDTORequest;
import com.senac.joaog.entity.Atendente;
import com.senac.joaog.entity.Role;
import com.senac.joaog.repository.AtendenteRepository;
import com.senac.joaog.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AtendenteService {

    private final AtendenteRepository atendenteRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public AtendenteService(AtendenteRepository atendenteRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.atendenteRepository = atendenteRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public Atendente criar(AtendenteDTORequest dto) {
        Atendente atendente = modelMapper.map(dto, Atendente.class);
        atendente.setChave_acesso(passwordEncoder.encode(dto.getChave_acesso()));
        atendente.setAtivo(1);

        Role role = RoleRepository.findByName(dto.getRole())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Role não encontrada"));
        atendente.setRoles(List.of(role));

        return atendenteRepository.save(atendente);
    }

    public Atendente alterarStatus(Long id, int status) {
        Atendente atendente = atendenteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendente não encontrado"));

        if (status != 0 && status != 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status deve ser 0 (Bloqueado) ou 1 (Ativo)");
        }
        atendente.setAtivo(status);
        return atendenteRepository.save(atendente);
    }

    public List<Atendente> listarTodosComChamadas() {
        return atendenteRepository.findAll();
    }

    public Atendente listarAtendentePorId(Integer idAtendente){
        return this.atendenteRepository.obterAlunoAtivoPorId(idAtendente);
    }
}