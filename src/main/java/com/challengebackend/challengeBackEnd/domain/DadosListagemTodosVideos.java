package com.challengebackend.challengeBackEnd.domain;

public record DadosListagemTodosVideos(
        Long id,
        String titulo,
        String descricao,
        String url) {
    public DadosListagemTodosVideos(Video video) {
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl());
    }
}
