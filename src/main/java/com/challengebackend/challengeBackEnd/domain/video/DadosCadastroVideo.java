package com.challengebackend.challengeBackEnd.domain.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroVideo(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url,
        @NotNull
        Long categoriaId
) {
}
