package com.challengebackend.challengeBackEnd.domain.categoria;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCategoria(
        @NotNull
        Long id,
        String titulo,
        String cor) {
}
