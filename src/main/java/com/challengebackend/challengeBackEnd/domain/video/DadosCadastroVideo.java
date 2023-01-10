package com.challengebackend.challengeBackEnd.domain.video;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroVideo (
        @NotBlank
        String titulo,
        @NotBlank
        String descricao,
        @NotBlank
        String url
) {
}
