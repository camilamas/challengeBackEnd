package com.challengebackend.challengeBackEnd.domain.video;

public record DadosListagemTodosVideos(Long id, String titulo) {
    public DadosListagemTodosVideos(Video video) {
        this(video.getId(), video.getTitulo());
    }
}
