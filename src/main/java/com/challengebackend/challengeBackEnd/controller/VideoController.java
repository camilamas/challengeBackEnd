package com.challengebackend.challengeBackEnd.controller;

import com.challengebackend.challengeBackEnd.domain.video.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemTodosVideos>> listarTodosVideos(@PageableDefault(size = 10) Pageable paginacao) {
        var page = videoRepository.findAll(paginacao).map(DadosListagemTodosVideos::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemVideo> listarVideo(@PathVariable Long id) {
        var video = videoRepository
                .getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemVideo(video));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemVideo> cadastrarVideo(@RequestBody @Valid DadosCadastroVideo dados, UriComponentsBuilder builder) {
        var video = new Video(dados);
        videoRepository.save(video);
        var uri = builder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemVideo(video));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var video = videoRepository.getReferenceById(id);
        videoRepository.delete(video);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoVideo dados) {
        var video = videoRepository.getReferenceById(dados.id());
        video.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemVideo(video));
    }

}
