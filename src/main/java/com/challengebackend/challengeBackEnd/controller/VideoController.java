package com.challengebackend.challengeBackEnd.controller;

import com.challengebackend.challengeBackEnd.ChallengeBackEndApplication;
import com.challengebackend.challengeBackEnd.domain.categoria.CategoriaRepository;
import com.challengebackend.challengeBackEnd.domain.video.*;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(ChallengeBackEndApplication.class);

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemTodosVideos>> listarTodosVideos(@PageableDefault(size = 10) Pageable paginacao, @RequestParam(required=false) String search) {
        var page = videoRepository.findAll(paginacao).map(DadosListagemTodosVideos::new);
        if (search != null) {
            var categoria = categoriaRepository.getReferenceByTitulo(search.toUpperCase());
            if(categoria != null) {
                page = videoRepository.findByCategoriaId(paginacao, categoria.getId()).map(DadosListagemTodosVideos::new);
            } else {
                return ResponseEntity.noContent().build();
            }
        }
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
