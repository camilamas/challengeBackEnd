package com.challengebackend.challengeBackEnd.domain.video;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "video")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String url;
    private Long categoriaId;

    public Video(DadosCadastroVideo dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
        this.categoriaId = dados.categoriaId();
    }

    public void atualizarInformacoes(DadosAtualizacaoVideo dados) {
        if (dados.titulo() != null) this.titulo = dados.titulo();
        if (dados.descricao() != null) this.descricao = dados.descricao();
        if (dados.url() != null) this.url = dados.url();
        if (dados.categoriaId() != null) this.categoriaId = dados.categoriaId();
    }
}
