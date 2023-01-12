package com.challengebackend.challengeBackEnd.domain.categoria;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCategoria(
        @NotBlank
        String titulo,
        @NotBlank
        String cor) {
}
