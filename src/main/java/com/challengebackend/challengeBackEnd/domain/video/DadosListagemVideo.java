package com.challengebackend.challengeBackEnd.domain.video;

public record DadosListagemVideo(Long id, String titulo, String descricao, String url) {

    public DadosListagemVideo(Video video) {
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
