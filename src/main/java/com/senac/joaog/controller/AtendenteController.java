package com.senac.joaog.controller;


import com.senac.joaog.dto.request.AtendenteDTORequest;
import com.senac.joaog.dto.request.LoginUserDTO;
import com.senac.joaog.dto.response.AtendenteDTOResponse;
import com.senac.joaog.dto.response.RecoveryJwtTokenDTO;
import com.senac.joaog.entity.Atendente;
import com.senac.joaog.service.AtendenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/atendente")
@Tag(name="Atendente", description = "Api para gerenciamento de atendente do sistema")
public class AtendenteController {

    private final AtendenteService atendenteService;

    public AtendenteController(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    @GetMapping("/listarPorIdAtendente/{idAtendente}")
    @Operation(summary = "Listar atendentes do sistema pelo id do atendentes")
    public ResponseEntity<Atendente> listarPorIdAtendente(@PathVariable("idAtendente") Integer idAtendente){
        Atendente atendente = atendenteService.listarAtendentePorId(idAtendente);
        if (atendente == null) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(atendente);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDTO> authenticateUser(@RequestBody LoginUserDTO loginUserDTO) {
        RecoveryJwtTokenDTO token = atendenteService.authenticateUser(loginUserDTO);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/criar")
    @Operation(summary = "Criar um novo atendente")
    public ResponseEntity<AtendenteDTOResponse> criar(@Valid @RequestBody AtendenteDTORequest atendenteDTORequest){
        return ResponseEntity.ok(atendenteService.salvar(atendenteDTORequest));
    }
}
