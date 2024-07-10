package com.aluraone.forum.domain.curso;

import jakarta.validation.constraints.NotBlank;

public record DadosCursoDto(@NotBlank String nome) {
}
