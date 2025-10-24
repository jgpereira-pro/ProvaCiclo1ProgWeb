package com.senac.joaog.controller;

import com.senac.joaog.dto.request.CreateUserDTO;
import com.senac.joaog.dto.request.LoginUserDTO;
import com.senac.joaog.dto.response.RecoveryJwtTokenDTO;
import com.senac.joaog.entity.Atendente;
import com.senac.joaog.service.AtendenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/atendente")
public class AtendenteController {
    private final AtendenteService atendenteService;

    public AtendenteController(AtendenteService atendenteService) {
        this.atendenteService = atendenteService;
    }

    @GetMapping("/listar")
    public ResponseEntity <List<Atendente>> listarTodos(){
        return ResponseEntity.ok(atendenteService.listarTodos());
    }

    @GetMapping("/listarporid/{id}")
    public ResponseEntity<Atendente> listarPorId(@PathVariable ("id") Integer id){
        return ResponseEntity.ok(atendenteService.listarPorId(id));
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> criarAtendente (@RequestBody CreateUserDTO createUserDTO){
        atendenteService.criarAtentende(createUserDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<RecoveryJwtTokenDTO> loginAtendente(@RequestBody LoginUserDTO loginUserDTO){
        return new ResponseEntity<>(atendenteService.login(loginUserDTO),HttpStatus.OK);
    }
}