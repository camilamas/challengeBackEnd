package com.challengebackend.challengeBackEnd.domain.categoria;

import com.challengebackend.challengeBackEnd.domain.video.Video;

public record DadosListagemVideosPorCategoria(
        Long id,
        String titulo,
        Long categoriaId,
        String categoriaTitulo) {

    public DadosListagemVideosPorCategoria(Video video, Categoria categoria) {
        this(video.getId(), video.getTitulo(), categoria.getId(), categoria.getTitulo());
    }
}
