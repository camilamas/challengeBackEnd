package com.challengebackend.challengeBackEnd.domain.categoria;

import com.challengebackend.challengeBackEnd.domain.video.DadosCadastroVideo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "categoria")
@Entity(name = "Categoria")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String cor;

    public Categoria(DadosCadastroCategoria dados) {
        this.titulo = dados.titulo();
        this.cor = dados.cor();
    }
}
