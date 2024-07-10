package com.aluraone.forum.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aluraone.forum.domain.usuario.DadosAutenticacaoDto;
import com.aluraone.forum.domain.usuario.Usuario;
import com.aluraone.forum.infra.security.TokenService;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacaoDto dados){

        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var autenticacao = manager.authenticate(token);
        return ResponseEntity.ok(tokenService.gerarToken((Usuario) autenticacao.getPrincipal()));

    }



}
