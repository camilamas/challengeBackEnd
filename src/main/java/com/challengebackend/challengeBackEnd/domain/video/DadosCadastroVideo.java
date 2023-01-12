package com.challengebackend.challengeBackEnd.domain.video;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVideo(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url
) {
}
