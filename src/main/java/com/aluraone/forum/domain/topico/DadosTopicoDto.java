package com.aluraone.forum.domain.topico;

import com.aluraone.forum.domain.curso.DadosListagemCursoDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosTopicoDto(

        @NotBlank(message = "Campo titulo é obrigatorio")
        String titulo,
        @NotBlank
        String mensagem,

        DadosListagemCursoDto curso){}
