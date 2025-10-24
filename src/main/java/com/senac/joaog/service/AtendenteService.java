package com.senac.joaog.service;

import com.senac.joaog.config.SecurityConfiguration;
import com.senac.joaog.dto.request.CreateUserDTO;
import com.senac.joaog.dto.request.LoginUserDTO;
import com.senac.joaog.dto.response.RecoveryJwtTokenDTO;
import com.senac.joaog.entity.Atendente;
import com.senac.joaog.entity.Role;
import com.senac.joaog.repository.AtendenteRepository;
import com.senac.joaog.repository.RoleRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtendenteService {
    private final AtendenteRepository atendenteRepository;
    private final RoleRepository roleRepository;
    private final SecurityConfiguration securityConfiguration;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenService jwtTokenService;

    public AtendenteService(AtendenteRepository atendenteRepository, RoleRepository roleRepository, SecurityConfiguration securityConfiguration, AuthenticationManager authenticationManager, JwtTokenService jwtTokenService) {
        this.atendenteRepository = atendenteRepository;
        this.roleRepository = roleRepository;
        this.securityConfiguration = securityConfiguration;
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
    }

    public List<Atendente> listarTodos(){
        return atendenteRepository.findAll();
    }
    public Atendente listarPorId(Integer id){
        return atendenteRepository.findById(id).orElse(null);
    }

    public void criarAtentende(CreateUserDTO createUserDTO) {
        Role role = roleRepository.findByName(createUserDTO.role());

        Atendente novoAtendente = new Atendente();

        novoAtendente.setNome(createUserDTO.nome());
        novoAtendente.setUsuarioLogin(createUserDTO.usuarioLogin());
        novoAtendente.setChaveAcesso(securityConfiguration.passwordEncoder().encode(createUserDTO.chaveAcesso()));
        novoAtendente.setDataCriacao(LocalDateTime.now());
        novoAtendente.setAtivo(1);
        novoAtendente.setRoles(List.of(role));
        atendenteRepository.save(novoAtendente);

    }

    public RecoveryJwtTokenDTO login(LoginUserDTO loginUserDTO) {
        //Passo 1
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
        usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginUserDTO.login(), loginUserDTO.chaveAcesso());
        //Passo 2
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        //Passo 3
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
        //Passo 4
        return new RecoveryJwtTokenDTO(jwtTokenService.generateToken(userDetails));

    }
}