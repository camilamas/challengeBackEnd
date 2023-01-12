package com.challengebackend.challengeBackEnd.domain.categoria;

public record DadosListagemTodasCategorias(Long id, String titulo, String cor) {

    public DadosListagemTodasCategorias(Categoria categoria) {
        this(categoria.getId(), categoria.getTitulo(), categoria.getCor());
    }

}
